package jonathanHughes.accessibility_extension.models;

import jonathanHughes.accessibility_extension.models.css.CssRuleSet;

public class CssReturnEntity {
	
	String oldSelector;
	String newRuleSet;
	
	public CssReturnEntity(String oldSelector, CssRuleSet ruleSet) {
		this.oldSelector = oldSelector;
		if (ruleSet.getSelector().startsWith("#")) {
			 ruleSet.setSelector("." + ruleSet.getSelector().substring(1));
		}
		this.newRuleSet = ruleSet.toString();
	}

	public CssReturnEntity(String selector, String ruleSet) {
		this.oldSelector = selector;
		this.newRuleSet = ruleSet;
	}

	public String getOldSelector() {
		return oldSelector;
	}

	public void setOldSelector(String oldSelector) {
		this.oldSelector = oldSelector;
	}

	public String getNewRuleSet() {
		return newRuleSet;
	}

	public void setNewRuleSet(String newRuleSet) {
		this.newRuleSet = newRuleSet;
	}

}
