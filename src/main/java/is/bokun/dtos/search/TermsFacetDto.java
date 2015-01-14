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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TermsFacetEntryDto> getEntries() {
		return entries;
	}

	public void setEntries(List<TermsFacetEntryDto> entries) {
		this.entries = entries;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
}
