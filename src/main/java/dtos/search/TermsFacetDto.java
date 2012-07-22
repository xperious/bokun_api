package dtos.search;

import java.util.ArrayList;
import java.util.List;

public class TermsFacetDto extends AbstractFacet {

	public String title;
	public List<TermsFacetEntryDto> entries = new ArrayList<TermsFacetEntryDto>();
	
	public TermsFacetDto() {}
	
	public TermsFacetDto(String name, String title) {
		super(name);
		this.title = title;
	}
	
}
