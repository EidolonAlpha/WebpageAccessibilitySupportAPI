package jonathanHughes.accessibility_extension.colour;

import java.io.IOException;
import java.net.http.HttpClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jonathanHughes.accessibility_extension.models.RGBValue;

@RestController
public class ContrastServiceController {
	
	HttpClient client = HttpClient.newHttpClient();
	ContrastService contrastService = new ContrastService();
	
	@RequestMapping(value="/contrast")
	public ResponseEntity<Object> getTextPreferences( @RequestParam final String RGB, final String RGB2) throws IOException, InterruptedException {
		System.out.println(RGB);
		System.out.println(RGB2);
		RGBValue value1 = new RGBValue(RGB.split(",")[0], RGB.split(",")[1], RGB.split(",")[2]);
		RGBValue value2 = new RGBValue(RGB2.split(",")[0], RGB2.split(",")[1], RGB2.split(",")[2]);
		double contrast = contrastService.getColourContrast(value1, value2);
		return new ResponseEntity<>(contrast, HttpStatus.OK);
	}
}
