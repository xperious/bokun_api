package dtos.search;

public class FacetEntry {

	public String term;
	public int count;
	
	public FacetEntry() {}
	
	public FacetEntry(String term, int count) {
		this.term = term;
		this.count = count;
	}
}
