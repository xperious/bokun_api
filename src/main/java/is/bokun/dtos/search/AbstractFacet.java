package is.bokun.dtos.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractFacet {

	public String name;
	
	public AbstractFacet() {}
	
	public AbstractFacet(String name) {
		this.name = name;
	}
}
