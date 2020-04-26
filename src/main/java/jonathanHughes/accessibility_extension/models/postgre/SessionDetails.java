package jonathanHughes.accessibility_extension.models.postgre;

import java.util.ArrayList;
import java.util.List;

public class SessionDetails {
	
	long userId;
	String url;
	CSSRuleSetDetails[] cssRules;
	
	public SessionDetails() {
		
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public CSSRuleSetDetails[] getCssRules() {
		return cssRules;
	}

	public void setCssRules(CSSRuleSetDetails[] cssRules) {
		this.cssRules = cssRules;
	}
	
	public List<String> getRuleSetsAsString() {
		List<String> ruleSets = new ArrayList<String>();
		for (CSSRuleSetDetails cssRuleSetDetails : cssRules) {
			ruleSets.add(cssRuleSetDetails.getNewRuleSet());
		}
		return ruleSets;
	}
	
}

