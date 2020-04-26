package jonathanHughes.accessibility_extension.text;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExtensionServiceFontController {
	
	FontModificationService fontModificationService = new FontModificationService();
	
	@RequestMapping(value = "/fontCalculation")
	public ResponseEntity<Object> getDesiredFont(@RequestParam String currentFontSize, @RequestParam String desiredIncreaseParam) throws IOException, InterruptedException {
		double fontSize = 0;
		double desiredIncrease = 0;
		try {
			fontSize = Double.parseDouble(currentFontSize);
			desiredIncrease = Double.parseDouble(desiredIncreaseParam);
		} catch (Exception e) {
			fontSize = 0;
			desiredIncrease = 0;
		}
		fontSize = fontModificationService.returnDesiredFontSize(desiredIncrease, fontSize);
		return new ResponseEntity<>(fontSize, HttpStatus.OK);
	}
}
