package dtos.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultsDto<T extends SearchResultItem> {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<T> items;
	
	public List<TermFilter> tagFilters = new ArrayList<TermFilter>();
	
	public TermsFacetDto typeFacet;
	public List<TermsFacetDto> tagFacets = new ArrayList<TermsFacetDto>();
	public StatisticalFacetDto priceFacet;
	
	public boolean hasTagFacet(String name) {
		return tagFacet(name) != null;
	}
	
	public TermsFacetDto tagFacet(String name) {
		for (TermsFacetDto facet : tagFacets) {
			if ( facet.name.equals(name) ) {
				return facet;
			}
		}
		return null;
	}

	public Set<String> tagFilterValues(String name) {
		Set<String> set = new HashSet<String>();
		for (TermFilter t : tagFilters) {
			if ( t.facetName.equals(name) ) {
				set.add(t.value);
			}
		}
 		return set;
	}
}
