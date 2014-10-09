package is.bokun.dtos.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.CustomerDto;
import is.bokun.dtos.ExtranetUserDto;
import is.bokun.dtos.ProductCategoryEnum;
import is.bokun.dtos.booking.*;
import is.bokun.utils.StringUtils;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBookingSearchResultItem {

	public Long id;
    public Long parentBookingId;
	public String confirmationCode;
    public String productConfirmationCode;
    public String status;
    public String externalBookingReference;
    public ProductCategoryEnum productCategory;
    public boolean resold;

    public boolean hasNotes;
	
	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public String productExternalId;
	public BookingItemInfoDto vendor;
	public BookingItemInfoDto seller;
	public AgentBookingDetailsDto agent;
    public BookingItemInfoDto affiliate;
	public BookingItemInfoDto saleSource;
	public ExtranetUserDto extranetUser;
    public BookingAgentUserDto agentUser;
    public CustomerDto customer;
	
	public Date creationDate;
	public String productType;

    public InvoiceDto customerInvoice;
    public InvoiceDto resellerInvoice;

	public int totalPrice;
	public String currency;
    public Double paidAmount;
    public String paidType;
    public String resellerPaidType;
    public Double discountPercentage;
    public Double discountAmount;
    public boolean unconfirmedPayments;

	public Date startDate, endDate;

    public Double sellerCommission;
    public Double affiliateCommission;
    public Double agentCommission;

    public List<BookingNoteDto> notes = new ArrayList<>();

	public Map<String,Object> fields = new HashMap<>();

    public boolean boxBooking;
    public BookingItemInfoDto boxProduct;
    public BookingItemInfoDto boxSupplier;

    @JsonIgnore
	public int getIntField(String name) {
		return (Integer) fields.get(name);
	}

    @JsonIgnore
    public Double getAgentSalesRevenue() {
        return customerInvoice.totalCommission;
    }

    @JsonIgnore
    public Double getSupplierRevenue() {
        return resellerInvoice.totalSansCommission;
    }

    @JsonIgnore
    public String getString(String fieldName, String defaultValue) {
        String value = (String) fields.get(fieldName);
        return value != null ? value : defaultValue;
    }

    @JsonIgnore
    public boolean getBoolean(String fieldName, boolean defaultValue) {
        Boolean value = (Boolean) fields.get(fieldName);
        if ( value != null ) {
            return value.booleanValue();
        } else {
            return defaultValue;
        }
    }

    @JsonIgnore
    public double getDouble(String fieldName, double defaultValue) {
        Double value = (Double) fields.get(fieldName);
        if ( value != null ) {
            return value.doubleValue();
        } else {
            return defaultValue;
        }
    }

    @JsonIgnore
    public boolean hasNotesByVendor(Long vendorId) {
        for (BookingNoteDto note : notes) {
            if (note.ownerId != null && note.ownerId.equals(vendorId)) {
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public boolean hasNotesByVendorAndType(Long vendorId, BookingNoteTypeEnum type) {
        for (BookingNoteDto note : notes) {
            if (note.ownerId != null && note.ownerId.equals(vendorId) && note.type.equals(type)) {
                return true;
            }
        }
        return false;
    }
	
	public String getCurrency() {
		if ( StringUtils.isNullOrEmpty(currency) ) {
			return "ISK";
		} else {
			return currency;
		}
	}
}
