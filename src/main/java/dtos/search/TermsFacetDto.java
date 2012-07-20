package dtos.search;

import java.util.ArrayList;
import java.util.List;

public class TermsFacetDto extends AbstractFacet {

	public List<TermsFacetEntryDto> entries = new ArrayList<TermsFacetEntryDto>();
	
	public TermsFacetDto() {}
	
	public TermsFacetDto(String name) {
		super(name);
	}
}
