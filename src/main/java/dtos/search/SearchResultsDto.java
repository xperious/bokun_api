package dtos.search;

import java.util.*;

public class SearchResultsDto<T extends SearchResultItem> {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<T> items;
	
	public List<TermFilter> tagFilters = new ArrayList<>();
	
	public List<TermsFacetDto> tagFacets = new ArrayList<>();
	public StatisticalFacetDto priceFacet;
	public Map<String,TermsFacetDto> termFacets = new HashMap<>();
	
	public boolean hasTermFacet(String name) {
		return termFacet(name) != null;
	}
	
	public TermsFacetDto termFacet(String name) {
		return termFacets.get(name);
	}	
	
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
