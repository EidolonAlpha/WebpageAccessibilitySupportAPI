package jonathanHughes.accessibility_extension;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jonathanHughes.accessibility_extension.text.FontModificationService;

public class FontModificationServiceTests {
	
	private FontModificationService fontModificationService;
	
	@Before
	public void setup() {
		fontModificationService = new FontModificationService();
	}
	
	@Test
	public void returns_desired_font_if_increase_is_0() {
		double increase = 0;
		double currentSize = 10;
		double expectedSize = increase + currentSize;
		double newFont = fontModificationService.returnDesiredFontSize(increase, currentSize);
		assertEquals(expectedSize, newFont);
	}
	
	@Test
	public void returns_desired_font_if_current_size_is_0() {
		double increase = 5;
		double currentSize = 0;
		double expectedSize = 0;
		double newFont = fontModificationService.returnDesiredFontSize(increase, currentSize);
		assertEquals(expectedSize, newFont);
	}
	
	@Test
	public void returns_desired_font_if_current_size_and_increase_is_0() {
		double increase = 0;
		double currentSize = 0;
		double expectedSize = increase + currentSize;
		double newFont = fontModificationService.returnDesiredFontSize(increase, currentSize);
		assertEquals(expectedSize, newFont);
	}
	
	@Test
	public void returns_desired_font_if_increase_ratio_is_above_threshold() {
		double increase = 5;
		double currentSize = 5;
		double expectedSize = (currentSize * (increase/100)) + currentSize;
		double newFont = fontModificationService.returnDesiredFontSize(increase, currentSize);
		assertEquals(expectedSize, newFont);
	}
	
	@Test
	public void returns_desired_font_if_increase_ratio_is_below_threshold() {
		double increase = 1;
		double currentSize = 10;
		double expectedSize = (currentSize * (increase/100)) + currentSize;
		double increaseThreshold = increase/currentSize;
		double newFont = fontModificationService.returnDesiredFontSize(increase, currentSize);
		assertFalse(fontModificationService.getFontIncreaseThreshold() < increaseThreshold);
		assertEquals(expectedSize, newFont);
	}

}
