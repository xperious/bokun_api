package is.bokun.dtos.search;

import java.util.ArrayList;
import java.util.List;

public class TermsFacetDto extends AbstractFacet {

	public String title;
	public List<TermsFacetEntryDto> entries = new ArrayList<>();
    public List<String> flags = new ArrayList<>();
	
	public TermsFacetDto() {}
	
	public TermsFacetDto(String name, String title, List<String> flags) {
		super(name);
		this.title = title;
        this.flags = flags;
	}
	
}
