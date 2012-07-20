package dtos.search;

public class TermsFacetEntryDto {

	public String term;
	public int count;
	
	public TermsFacetEntryDto() {}
	
	public TermsFacetEntryDto(String term, int count) {
		this.term = term;
		this.count = count;
	}
}
