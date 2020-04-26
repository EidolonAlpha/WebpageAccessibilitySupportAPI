package jonathanHughes.accessibility_extension.colour;

import jonathanHughes.accessibility_extension.models.RGBValue;

public class ContrastService {
	
	public RGBValue calculateContrastingColour(RGBValue colour) {
		return new RGBValue(255- colour.getRed(), 255- colour.getGreen(), 255- colour.getBlue());
	}
	
	
	
	public double getColourContrast(RGBValue colour1, RGBValue colour2) {
		return ((getColourLuminance(colour1) + 0.05) / (getColourLuminance(colour2)+0.05));
	}
	
	private double gammaAdjustedNormalizeRGBValue(int colourValue) {
		return Math.pow(colourValue/255, 2.2);
	}
	
	private double getColourLuminance(RGBValue colour) {
		//L = 0.2126 * Rg + 0.7152 * Gg + 0.0722 * Bg
		double colourLuminance =  (0.2126 * gammaAdjustedNormalizeRGBValue(colour.getRed())) + 
								   (0.7152 * gammaAdjustedNormalizeRGBValue(colour.getGreen())) + 
								   (0.0722 * gammaAdjustedNormalizeRGBValue(colour.getBlue()));
		return colourLuminance;
	}
	
	/*
	 * private double getColourLuminance(RGBValue colour) { //L = 0.2126 * Rg +
	 * 0.7152 * Gg + 0.0722 * Bg double colourLuminance = (0.2126 *
	 * calculateXgValue(colour.getRed())) + (0.7152 *
	 * calculateXgValue(colour.getGreen())) + (0.0722 *
	 * calculateXgValue(colour.getBlue())); return colourLuminance; }
	 */
	
//	private double calculate_sRGB_Value(int colourValue) {
//		if (colourValue <= 0.03928) {
//			return colourValue/12.92;
//		} 
//		else {
//			return Math.pow(((colourValue + 0.055/1.055)), 2.4);
//		}
//	} 
//	
//	private double calculateXgValue(int colourValue) {
//		if (colourValue <= 10) {
//			return colourValue/3294;
//		} 
//		else {
//			return Math.pow(((colourValue/269) + 0.0513), 2.4);
//		}
//	}
	
	

}
