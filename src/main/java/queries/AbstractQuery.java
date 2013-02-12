package queries;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.StringUtils;

/**
 * An abstract query class, combining all the common properties of the product query classes.
 * 
 * @author Olafur Gauti Gudmundsson
 */
public abstract class AbstractQuery {
	
	public TextFilter textFilter;
	
    public int page = 1;
    public int pageSize = 20;
    
	public String sortField;
	public String sortOrder;
	
	public List<FacetFilter> facetFilters = new ArrayList<>();
	
	public NumericRangeFilter priceRangeFilter;
    
    public AbstractQuery() {
    }
    
	public void setTextFilter(TextFilter textFilter) {
		this.textFilter = textFilter;
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
		return new ArrayList<String>();
	}
	
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

	
	public void setPriceRangeFilter(NumericRangeFilter priceRangeFilter) {
		this.priceRangeFilter = priceRangeFilter;
	}
	
	@JsonIgnore
	public boolean hasPriceRangeFilter() {
		if ( priceRangeFilter == null ) {
			return false;
		}
		return priceRangeFilter.isActive();
	}

}
