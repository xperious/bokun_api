package is.bokun.queries;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

/**
 * An abstract query class, combining all the common properties of the product query classes.
 * 
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractQuery {

    /**
     * Specifying this filter will filter the results using a textual search.
     */
	public TextFilter textFilter;

    /**
     * Specifying this filter will filter the results by the external Id specified
     * by the product owner.
     */
    public String externalId;

    /**
     * Number of the page to retrieve in the paginated result list.
     * Default value is 1.
     */
    public int page = 1;
    /**
     * Number of result on each page in the paginated result list.
     * Default value is 20.
     */
    public int pageSize = 20;

    /**
     * Filter only the products that have been published since the date
     * specified here. Date format is yyyy-MM-dd HH:mm:ss.
     */
    public String publishedSince;

    /**
     * The name of the field to sort the results by.
     */
	public String sortField;
    /**
     * The sort order. Either "asc" or "desc". Defaults to "asc".
     */
	public String sortOrder;

    /**
     * A list of filters to filter the results by facets.
     */
	public List<FacetFilter> facetFilters = new ArrayList<>();

    public AbstractQuery() {
    }
    
	public void setTextFilter(TextFilter textFilter) {
		this.textFilter = textFilter;
	}

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setPage(int page) {
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public void setSortOrder(String s) {
		this.sortOrder = s;
	}

    public String getPublishedSince() {
        return publishedSince;
    }

    public void setPublishedSince(String publishedSince) {
        this.publishedSince = publishedSince;
    }

    /**
     * Check whether we should filter using textual search.
     * @return true if text filter is active, else false
     */
    @JsonIgnore
    public boolean isTextFilterActive() {
        return textFilter != null && textFilter.isActive();
    }
	
	@JsonIgnore
	public SortOrder orderBy() {
		if (StringUtils.isNullOrEmpty(sortOrder) ) {
			return null;
		} else {
			try {
				return SortOrder.valueOf(sortOrder.toUpperCase());
			} catch ( Throwable ignored ) {
				return null;
			}
		}
	}
	
	@JsonIgnore
    public int validatedPage() {
        if ( page <= 0 ) {
            return 1;
        }
        return page;
    }
    
	@JsonIgnore
    public int validatedPageSize() {
        if ( pageSize <= 0 ) {
            return 20;
        }
        return pageSize;
    }
	
	/**
	 * Adds a Facet filter for the tag.
	 * @param tagGroupFacetName The name of the facet defined for the Tag Group.
	 * @param tagId The ID of the tag to filter by.
	 */
	public void addTagFilter(String tagGroupFacetName, Long tagId) {
		this.facetFilters.add(new FacetFilter(tagGroupFacetName, tagId.toString()));
	}
    
	public void setFacetFilters(List<FacetFilter> facetFilters) {
		this.facetFilters = facetFilters;
	}
	
	@JsonIgnore
	public List<String> getFacetFilterValues(String facetName) {
		for (FacetFilter f : facetFilters) {
			if ( f.name.equals(facetName) ) {
				return f.values;
			}
		}
		return new ArrayList<>();
	}

    /**
     * Check if filtering by the facet with the name supplied.
     *
     * @param facetName name of the facet
     * @return true if filtering by the facet, else false
     */
	@JsonIgnore
	public boolean hasFacetFilter(String facetName) {
		for (FacetFilter f : facetFilters) {
			if ( f.name.equals(facetName) && !f.values.isEmpty() ) {
				return true;
			}
		}
		return false;
	}
	
	@JsonIgnore
	public FacetFilter findFacetFilter(String facetName) {
		for (FacetFilter f : facetFilters) {
			if ( f.name.equals(facetName) && !f.values.isEmpty() ) {
				return f;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public String getSingleFacetFilterValue(String facetName) {
		for (FacetFilter f : facetFilters) {
			if ( f.name.equals(facetName) ) {
				if ( f.values.isEmpty() ) {
					return "";
				} else {
					return f.values.iterator().next();
				}
			}
		}
		return "";
	}


	public TextFilter getTextFilter() {
		return textFilter;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public List<FacetFilter> getFacetFilters() {
		return facetFilters;
	}

}
