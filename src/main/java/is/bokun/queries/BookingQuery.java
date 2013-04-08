package is.bokun.queries;

import java.util.*;

public class BookingQuery {

	public String confirmationCode;
	public String productType;
	
	public List<Long> bookingChannelIds = new ArrayList<>();
	public List<Long> vendorIds = new ArrayList<>();
	public List<Long> sellingVendorIds = new ArrayList<>();
	public List<Long> productIds = new ArrayList<>();

    public String textFilter;

	public String productTitle;
	public String vendorTitle;
	public String sellerTitle;
	public String bookingChannelTitle;

    public DateRangeFilter creationDateRange = new DateRangeFilter();

    public boolean hasCreationDateRange() {
        return creationDateRange != null && creationDateRange.isActive();
    }
    public DateRangeFilter getCreationDateRange() {
        return creationDateRange;
    }
    public void setCreationDateRange(DateRangeFilter creationDateRange) {
        this.creationDateRange = creationDateRange;
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
	private static List<Long> cleanList(List<Long> l) {
		List<Long> list = new ArrayList<>();
		for (Long lng : l) {
			if ( lng != null ) {
				list.add(lng);
			}
		}
		return list;
	}
}
