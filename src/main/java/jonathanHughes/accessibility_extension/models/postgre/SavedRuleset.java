package jonathanHughes.accessibility_extension.models.postgre;

public class SavedRuleset {
	
	String _id;
	String cssRuleSet;
	
	public SavedRuleset() {
	}

	public SavedRuleset(String _id, String cssRuleSet) {
		this._id = _id;
		this.cssRuleSet = cssRuleSet;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCssRuleSet() {
		return cssRuleSet;
	}

	public void setCssRuleSet(String cssRuleSet) {
		this.cssRuleSet = cssRuleSet;
	}
	 
}
