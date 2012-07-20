package queries;

import java.util.Set;

import utils.StringUtils;

public class FacetQuery {

	public String name;
	public String values;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setValues(String values) {
		this.values = values;
	}
	
	public Set<String> valuesAsList() {
		return StringUtils.commaSeparatedToSet(values);
	}
}
