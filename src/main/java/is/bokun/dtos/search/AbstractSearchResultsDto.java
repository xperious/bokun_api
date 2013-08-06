package is.bokun.dtos.search;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractSearchResultsDto {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<TermFilter> tagFilters = new ArrayList<>();
	
	public List<TermsFacetDto> tagFacets = new ArrayList<>();
	public StatisticalFacetDto priceFacet;
	public Map<String,TermsFacetDto> termFacets = new HashMap<>();

    @JsonIgnore
	public boolean hasTermFacet(String name) {
		return termFacet(name) != null;
	}

    @JsonIgnore
	public TermsFacetDto termFacet(String name) {
		return termFacets.get(name);
	}

    @JsonIgnore
	public boolean hasTagFacet(String name) {
		return tagFacet(name) != null;
	}

    @JsonIgnore
	public TermsFacetDto tagFacet(String name) {
		for (TermsFacetDto facet : tagFacets) {
			if ( facet.name.equals(name) ) {
				return facet;
			}
		}
		return null;
	}

    @JsonIgnore
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
