package is.bokun.dtos.search;

import is.bokun.dtos.CustomerDto;
import is.bokun.dtos.booking.BookingItemInfoDto;
import is.bokun.utils.StringUtils;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBookingSearchResultItem {

	public Long id;
	public String confirmationCode;
    public String status;
	
	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public BookingItemInfoDto vendor;
	public BookingItemInfoDto seller;
	public BookingItemInfoDto agent;
	public BookingItemInfoDto saleSource;
    public CustomerDto customer;
	
	public Date creationDate;
	public String productType;
	public int totalPrice;
	public String currency;
    public Double paidAmount;
    public String paidType;
    public Double discountPercentage;
    public boolean unconfirmedPayments;
	public Date startDate, endDate;
	public Map<String,Object> fields = new HashMap<>();
	
	@JsonIgnore
	public int getIntField(String name) {
		return (Integer) fields.get(name);
	}
	
	public String getCurrency() {
		if ( StringUtils.isNullOrEmpty(currency) ) {
			return "ISK";
		} else {
			return currency;
		}
	}
}
