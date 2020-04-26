package jonathanHughes.accessibility_extension.models.css;

import java.util.List;

public class CssRuleSet {
	
	private String selector;
	private List<CssDeclaration> cssDeclarationList;
	private String mediaRestrictionRule;
	
	public CssRuleSet(String selector, List<CssDeclaration> declarationList) {
		this.selector = selector;
		this.cssDeclarationList = declarationList;
		this.mediaRestrictionRule = "";
	}
	
	public CssRuleSet(String selector, List<CssDeclaration> declarationList, String mediaRestrictionRule) {
		this.selector = selector;
		this.cssDeclarationList = declarationList;
		this.mediaRestrictionRule = mediaRestrictionRule;
	}
	
	public void setSelector(String selector) {
		this.selector = selector;
	}

	public void setCssDeclarationList(List<CssDeclaration> cssDeclarationList) {
		this.cssDeclarationList = cssDeclarationList;
	}
	
	public String getFullSelector() {
		if (mediaRestrictionRule.isEmpty()) {
			return selector;
		}
		else {
			return mediaRestrictionRule + " " + selector;
		}
	}

	public String getSelector() {
		return selector;
	}

	public List<CssDeclaration> getCssDeclaration() {
		return cssDeclarationList;
	}
	
	public CssDeclaration getCssDelaration(String property) {
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (cssDeclaration.getProperty().equals(property)) {
				return cssDeclaration;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String css = "";
		if (!mediaRestrictionRule.isEmpty()) {
			css += mediaRestrictionRule + "{";
		}
		
		css += selector + " { ";
		
		for (CssDeclaration cssDeclaration : cssDeclarationList) {
			if (!cssDeclaration.toString().equals(": ;")) {
				css += cssDeclaration.toString().trim() + " ";
			}
		}
		css = css.trim() + " }";
		
		if (!mediaRestrictionRule.isEmpty()) {
			css += "}";
		}
		
		return css;
	}

	public String getMediaRestrictionRule() {
		return mediaRestrictionRule;
	}

	public void setMediaRestrictionRule(String mediaRestrictionRule) {
		this.mediaRestrictionRule = mediaRestrictionRule;
	}
}
