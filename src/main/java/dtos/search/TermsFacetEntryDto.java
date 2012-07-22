package dtos.search;

public class TermsFacetEntryDto {

	public String title;
	public String term;
	public int count;
	
	public TermsFacetEntryDto() {}
	
	public TermsFacetEntryDto(String title, String term, int count) {
		this.title = title;
		this.term = term;
		this.count = count;
	}
}
