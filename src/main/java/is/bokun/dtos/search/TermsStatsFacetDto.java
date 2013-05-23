package is.bokun.dtos.search;

import java.util.*;

public class TermsStatsFacetDto extends AbstractFacet {

	public List<StatisticalFacetDto> entries = new ArrayList<>();
	
	public TermsStatsFacetDto() {}
	
	public TermsStatsFacetDto(String name) {
		super(name);
	}
}
