package dtos.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchResultsDto<T extends SearchResultItem> {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<T> items;
	
	public Map<String,TermsFacetDto> termsFacets = new HashMap<String,TermsFacetDto>();
	public Map<String,StatisticalFacetDto> statisticalFacets = new HashMap<String,StatisticalFacetDto>();
	
	public boolean hasTermsFacet(String name) {
		return termsFacets.containsKey(name);
	}
	
	public TermsFacetDto termsFacet(String name) {
		return termsFacets.get(name);
	}
	
	public boolean hasStatisticalFacet(String name) {
		return statisticalFacets.containsKey(name);
	}
	
	public StatisticalFacetDto statisticalFacet(String name) {
		return statisticalFacets.get(name);
	}
}
