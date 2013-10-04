package is.bokun.dtos.search;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TermsStatsFacetDto extends AbstractFacet {

	public List<StatisticalFacetDto> entries = new ArrayList<>();
	
	public TermsStatsFacetDto() {}
	
	public TermsStatsFacetDto(String name) {
		super(name);
	}
}
