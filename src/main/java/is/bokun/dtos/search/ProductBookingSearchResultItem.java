package is.bokun.dtos.search;

import is.bokun.dtos.*;
import is.bokun.dtos.booking.BookingItemInfoDto;
import is.bokun.utils.StringUtils;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBookingSearchResultItem {

	public Long id;
	public String confirmationCode;
    public String status;
	
	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public String productExternalId;
	public BookingItemInfoDto vendor;
	public BookingItemInfoDto seller;
	public BookingItemInfoDto agent;
    public BookingItemInfoDto affiliate;
	public BookingItemInfoDto saleSource;
	public ExtranetUserDto extranetUser;
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

    public Double affiliateCommission;

	public Map<String,Object> fields = new HashMap<>();

    public boolean boxBooking;
    public BookingItemInfoDto boxProduct;
    public BookingItemInfoDto boxSupplier;
	
	@JsonIgnore
	public int getIntField(String name) {
		return (Integer) fields.get(name);
	}

    @JsonIgnore
    public Double getAffiliateCommissionAmount() {
        if ( affiliateCommission != null ) {
            double base = (double) totalPrice;
            return Math.floor(base * (affiliateCommission.doubleValue() / 100d) + 0.5d);
        } else {
            return 0d;
        }
    }
	
	public String getCurrency() {
		if ( StringUtils.isNullOrEmpty(currency) ) {
			return "ISK";
		} else {
			return currency;
		}
	}
}
