package jonathanHughes.accessibility_extension.colour;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import jonathanHughes.accessibility_extension.models.RGBValue;

class ContrastServiceTest {
	
	private ContrastService contrastService = new ContrastService();
	
	@Before
	public void setup() {
		contrastService = new ContrastService();
	}

//	@Test
//	void contrast_between_black_and_blue() {
//		RGBValue black = new RGBValue(255, 255, 255);
//		RGBValue blue = new RGBValue(0,0,255);
//		
//		assertEquals(8.592, contrastService.getColourContrast(black, blue));
//	}
//	
//	@Test
//	void contrasting_colour_of() {
//		RGBValue black = new RGBValue(255, 255, 255);
//		RGBValue inversion = contrastService.calculateContrastingColour(black);
//		assertEquals("", inversion);
//	}

}
