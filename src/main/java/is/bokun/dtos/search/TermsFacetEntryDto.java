package is.bokun.dtos.search;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TermsFacetEntryDto {

	public String title;
	public String term;
	public int count;
    public List<String> flags = new ArrayList<>();
	
	public TermsFacetEntryDto() {}
	
	public TermsFacetEntryDto(String title, String term, int count) {
        this(title, term, count, new ArrayList<String>());
    }

    public TermsFacetEntryDto(String title, String term, int count, List<String> flags) {
		this.title = title;
		this.term = term;
		this.count = count;
        this.flags = flags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
}
