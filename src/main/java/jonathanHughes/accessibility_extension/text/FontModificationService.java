package jonathanHughes.accessibility_extension.text;

public class FontModificationService {
	
	private final double FONT_INCREASE_THRESHOLD = 10;
	
	public double returnDesiredFontSize(double desiredIncrease, double currentFontSize) {
		return calculateIncrease(desiredIncrease, currentFontSize);
	}
	
	private double calculateIncrease(double desiredIncrease, double currentFontSize) {
		double increase = (currentFontSize * (desiredIncrease/100));
		if (increase < FONT_INCREASE_THRESHOLD) {
			return currentFontSize + increase;
		} else {
			return currentFontSize;
		}
	}

	public double getFontIncreaseThreshold() {
		return FONT_INCREASE_THRESHOLD;
	}
	
}
