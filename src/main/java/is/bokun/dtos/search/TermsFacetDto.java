package is.bokun.dtos.search;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	@JsonIgnore
	public boolean hasTerm(String term) {
		for (TermsFacetEntryDto e : entries) {
			if ( e.term.equals(term) ) {
				return true;
			}
		}
		return false;
	}
	
}
