package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookingQuery {
	
    /**
     * Number of the page to retrieve in the paginated result list.
     * Default value is 1.
     */
    public int page = 1;
    /**
     * Number of result on each page in the paginated result list.
     * Default value is 50.
     */
    public int pageSize = 50;

	public String confirmationCode;
	public String productType;

    public boolean excludeComboBookings;
    public Long excludeComboBookingsBySupplierId;

    public boolean supplierAndSellerAreDifferent;
    public boolean soldByAgent;
    public boolean soldByAgentOrReseller;
    public boolean soldByAffiliateOrAsReseller;

	public List<Long> bookingChannelIds = new ArrayList<>();
	public List<Long> vendorIds = new ArrayList<>();
	public List<Long> sellingVendorIds = new ArrayList<>();
	public List<Long> productIds = new ArrayList<>();
    public Long extranetUserId;
	public Long agentId;
    public List<Long> agentIds = new ArrayList<>();
    public Long affiliateId;
    public Long affiliateOwnerId;

    public String textFilter;

	public String productTitle;
    public String productExternalId;
	public String vendorTitle;
	public String sellerTitle;
	public String bookingChannelTitle;
    public String noteQuery;
	
	public Map<String,Object> fields = new HashMap<>();
    public Map<String,NumericRangeFilter> rangeFilters = new HashMap<>();
	
	public List<SortField> sortFields = new ArrayList<>();
	
	public List<String> bookingStatuses = new ArrayList<>();
	
	public List<Long> bookedExtrasIds = new ArrayList<>();

    public DateRangeFilter creationDateRange = new DateRangeFilter();
    public DateRangeFilter startDateRange = new DateRangeFilter();

    public boolean hasCreationDateRange() {
        return creationDateRange != null && creationDateRange.isActive();
    }
    public DateRangeFilter getCreationDateRange() {
        return creationDateRange;
    }
    public void setCreationDateRange(DateRangeFilter creationDateRange) {
        this.creationDateRange = creationDateRange;
    }
    public boolean hasStartDateRange() {
        return startDateRange != null && startDateRange.isActive();
    }
    public DateRangeFilter getStartDateRange() {
		return startDateRange;
	}
	public void setStartDateRange(DateRangeFilter startDateRange) {
		this.startDateRange = startDateRange;
	}
	public String getTextFilter() {
        return textFilter;
    }
    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }
    public String getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public List<Long> getBookingChannelIds() {
		return cleanList(bookingChannelIds);
	}
	public void setBookingChannelIds(List<Long> bookingChannelIds) {
		this.bookingChannelIds = bookingChannelIds;
	}
	public List<Long> getVendorIds() {
		return cleanList(vendorIds);
	}
	public void setVendorIds(List<Long> vendorIds) {
		this.vendorIds = vendorIds;
	}
	public List<Long> getSellingVendorIds() {
		return cleanList(sellingVendorIds);
	}
	public void setSellingVendorIds(List<Long> sellingVendorIds) {
		this.sellingVendorIds = sellingVendorIds;
	}
	public List<Long> getProductIds() {		
		return cleanList(productIds);
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getVendorTitle() {
		return vendorTitle;
	}
	public void setVendorTitle(String vendorTitle) {
		this.vendorTitle = vendorTitle;
	}
	public String getSellerTitle() {
		return sellerTitle;
	}
	public void setSellerTitle(String sellerTitle) {
		this.sellerTitle = sellerTitle;
	}
	public String getBookingChannelTitle() {
		return bookingChannelTitle;
	}
	public void setBookingChannelTitle(String bookingChannelTitle) {
		this.bookingChannelTitle = bookingChannelTitle;
	}

    public Map<String, NumericRangeFilter> getRangeFilters() {
        return rangeFilters;
    }

    public void setRangeFilters(Map<String, NumericRangeFilter> rangeFilters) {
        this.rangeFilters = rangeFilters;
    }

    public Long getExcludeComboBookingsBySupplierId() {
        return excludeComboBookingsBySupplierId;
    }

    public void setExcludeComboBookingsBySupplierId(Long excludeComboBookingsBySupplierId) {
        this.excludeComboBookingsBySupplierId = excludeComboBookingsBySupplierId;
    }

    public void setExtranetUserId(Long extranetUserId) {
        this.extranetUserId = extranetUserId;
    }

    public String getProductExternalId() {
        return productExternalId;
    }

    public void setProductExternalId(String productExternalId) {
        this.productExternalId = productExternalId;
    }

    public List<Long> getBookedExtrasIds() {
		return bookedExtrasIds;
	}
	public void setBookedExtrasIds(List<Long> bookedExtrasIds) {
		this.bookedExtrasIds = bookedExtrasIds;
	}
	public List<String> getBookingStatuses() {
		return bookingStatuses;
	}
	public void setBookingStatuses(List<String> bookingStatuses) {
		this.bookingStatuses = bookingStatuses;
	}
	public Map<String, Object> getFields() {
		return fields;
	}
	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}
	public List<SortField> getSortFields() {
		return sortFields;
	}
	public void setSortFields(List<SortField> sortFields) {
		this.sortFields = sortFields;
	}
    public Long getExtranetUserId() {
        return extranetUserId;
    }
	public Long getAgentId() {
		return agentId;
	}
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

    public Long getAffiliateOwnerId() {
        return affiliateOwnerId;
    }

    public void setAffiliateOwnerId(Long affiliateOwnerId) {
        this.affiliateOwnerId = affiliateOwnerId;
    }

    public Long getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(Long affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getNoteQuery() {
        return noteQuery;
    }

    public void setNoteQuery(String noteQuery) {
        this.noteQuery = noteQuery;
    }

    public List<Long> getAgentIds() {
        return agentIds;
    }

    public void setAgentIds(List<Long> agentIds) {
        this.agentIds = agentIds;
    }

    private static List<Long> cleanList(List<Long> l) {
		List<Long> list = new ArrayList<>();
        if ( l != null ) {
            for (Long lng : l) {
                if (lng != null) {
                    list.add(lng);
                }
            }
        }
		return list;
	}
}
