package jonathanHughes.accessibility_extension.layout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jonathanHughes.accessibility_extension.models.CssReturnEntity;
import jonathanHughes.accessibility_extension.models.postgre.SavedRuleset;
import jonathanHughes.accessibility_extension.models.postgre.SessionDetails;
import jonathanHughes.accessibility_extension.user.UserService;

@RestController
public class LayoutController {
	
	@Autowired
	private LayoutPreferenceService layoutService;
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private UserService userService;

	@RequestMapping(value="/getInjectionCssRules")
	public ResponseEntity<Object> getRulesToInject(@RequestBody String userPreference) throws IOException, InterruptedException{
		System.out.println("Getting CssRulesToInject");
		String response = layoutService.getUserLayoutPreferenceFromPostrge(userPreference);
		List<CssReturnEntity> returnEntity = new ArrayList<CssReturnEntity>();
		
		String[] responseArray = mapper.readValue(response, String[].class);
		
		for (String ruleSet : responseArray) {
			returnEntity.add(new CssReturnEntity(ruleSet.substring(0, ruleSet.indexOf("{")-1),ruleSet));
		}
		return new ResponseEntity<>(returnEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteWebpageModification")
	public ResponseEntity<Object> deleteRules(@RequestBody String sessionDetails) throws IOException, InterruptedException{
		System.out.println("deleteingRules");
		SessionDetails details = mapper.readValue(sessionDetails, SessionDetails.class);
		String sessionDetais = "{\"userId\":" + details.getUserId() + ", \"url\": \"" + details.getUrl() +"\"}";
		layoutService.deleteWebpagePreference(sessionDetais);
		return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/saveInjectionCssRules")
	public ResponseEntity<Object> saveRulesets(@RequestBody String sessionDetails) throws IOException, InterruptedException{
		SessionDetails details = mapper.readValue(sessionDetails, SessionDetails.class);
		String id = userService.getUserId(String.valueOf(details.getUserId()));
		if (id.isEmpty()) {
			id = userService.createUser();
		}
		String url = details.getUrl();
		String injectedCSS;
		
		if (!id.isEmpty()) {
			String sessionDetais = "{\"userId\":" + details.getUserId() + ", \"url\": \"" + url +"\"}";
			injectedCSS = layoutService.getUserLayoutPreferenceFromPostrge(sessionDetais);
			injectedCSS = injectedCSS.substring(1, injectedCSS.length() - 1);
				for (String cssRule : details.getRuleSetsAsString()) {
					String savedRuleSetDetails = layoutService.saveCssRulesets(cssRule);
					SavedRuleset ruleSet = mapper.readValue(savedRuleSetDetails, SavedRuleset.class);
					String webpagePref = "{\"userId\":" + details.getUserId() + ", \"url\": \"" + url +"\", \"ruleSetIdArray\":" + ruleSet.get_id() + "}";
					layoutService.saveWebpagePreference(webpagePref);
				}
			return new ResponseEntity<>(injectedCSS, HttpStatus.OK);
		}
		return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
	}	
}
