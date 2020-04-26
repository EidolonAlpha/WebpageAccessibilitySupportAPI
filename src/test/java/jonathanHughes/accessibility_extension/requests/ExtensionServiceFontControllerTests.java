package jonathanHughes.accessibility_extension.requests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import jonathanHughes.accessibility_extension.text.ExtensionServiceFontController;

public class ExtensionServiceFontControllerTests {
	
	private ExtensionServiceFontController fontController;

	@Before
	public void setup() {
		fontController = new ExtensionServiceFontController();
	}
	
	@Test
	public void recieved_valid_request_params_tests() {
		String currentFontSize = "5";
		String fontIncrease = "2";
		ResponseEntity<Object> response = null;
		try {
			response = fontController.getDesiredFont(currentFontSize, fontIncrease);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object body = response.getBody();
		assertEquals(5.1, body);
	}
	
	@Test
	public void recieved_invalid_request_params_tests() {
		String currentFontSize = "INVALID";
		String fontIncrease = "2";
		ResponseEntity<Object> response = null;
		try {
			response = fontController.getDesiredFont(currentFontSize, fontIncrease);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object body = response.getBody();
		assertEquals(0.0, body);
	}
	
}
