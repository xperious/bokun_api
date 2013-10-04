package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SortField {

	public String name;
	public SortOrder order;
	
	public SortField() {}
	
	public SortField(String name, SortOrder order) {
		this.name = name;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SortOrder getOrder() {
		return order;
	}

	public void setOrder(SortOrder order) {
		this.order = order;
	}
	
}
