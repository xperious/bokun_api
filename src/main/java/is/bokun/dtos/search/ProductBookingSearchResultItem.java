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
	public int totalPrice;
	public String currency;
    public Double paidAmount;
    public String paidType;
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

    public boolean arrived;

    @JsonIgnore
	public int getIntField(String name) {
		return (Integer) fields.get(name);
	}

    @JsonIgnore
    public Double getAffiliateCommissionAmount() {
        return getCommissionAmount(affiliateCommission);
    }

    @JsonIgnore
    public Double getAgentCommissionAmount() {
        return getCommissionAmount(agentCommission);
    }

    @JsonIgnore
    public Double getSupplierRevenueAmount() {
        return getRevenueAmount(sellerCommission);
    }

    @JsonIgnore
    private Double getCommissionAmount(Double comm) {
        if ( comm != null ) {
            double base = (double) totalPrice;
            return Math.floor(base * (comm.doubleValue() / 100d) + 0.5d);
        } else {
            return 0d;
        }
    }

    @JsonIgnore
    private Double getRevenueAmount(Double comm) {
        if ( comm != null ) {
            double base = (double) totalPrice;
            return Math.floor(base*(1 - comm.doubleValue() / 100d) + 0.5d);
        } else {
            return (double) totalPrice;
        }
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
