package jonathanHughes.accessibility_extension.models.css;

import java.util.List;

public class CssDeclaration {
	
	private String property;
	private List<String> values;

	public CssDeclaration(String property, List<String> values) {
		this.property = property;
		this.values = values;
	}
		
	public void setValues(List<String> values) {
		this.values = values;
	}

	public String getProperty() {
		return property;
	}

	public List<String> getValues() {
		return values;
	}

	@Override
	public String toString() {
		String attribute = property + ": ";
		for (int i = 0; i < values.size(); i++) {
			attribute += values.get(i);
			if (i < values.size()-1) {
				attribute += ", ";
			}else if (i == values.size() -1) {
				attribute += ";";
			}
		}
		return attribute;
	}
}
