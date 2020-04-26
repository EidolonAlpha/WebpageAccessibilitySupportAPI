package jonathanHughes.accessibility_extension.models;

public class RGBValue {
	
	private int red;
	private int green;
	private int blue;
	
	public RGBValue(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public RGBValue(String red, String green, String blue) {
		this.red = Integer.parseInt(red);
		this.green = Integer.parseInt(green);
		this.blue = Integer.parseInt(blue);
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
	
}
