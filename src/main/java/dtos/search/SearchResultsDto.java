package dtos.search;

import java.util.ArrayList;
import java.util.List;

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

}
