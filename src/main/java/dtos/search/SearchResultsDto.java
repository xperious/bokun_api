package dtos.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResultsDto<T extends SearchResultItem> {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<T> items;
	
	public Map<String,TermsFacet> termFacets = new HashMap<String,TermsFacet>();
}
