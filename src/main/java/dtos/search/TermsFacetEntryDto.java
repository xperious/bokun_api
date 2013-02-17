package dtos.search;

import java.util.ArrayList;
import java.util.List;

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
}
