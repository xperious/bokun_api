package is.bokun.dtos.search;

import java.util.Date;

import is.bokun.dtos.CustomerDto;
import is.bokun.utils.StringUtils;

import is.bokun.dtos.booking.BookingItemInfoDto;

public class ProductBookingSearchResultItem {

	public Long id;
	public String confirmationCode;
    public String status;
	
	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public BookingItemInfoDto vendor;
	public BookingItemInfoDto seller;
    public CustomerDto customer;
	
	public Date creationDate;
	public String productType;
	public int totalPrice;
	public String currency;
    public Double paidAmount;
    public String paidType;
    public boolean unconfirmedPayments;
	public Date startDate, endDate;
	
	public String getCurrency() {
		if ( StringUtils.isNullOrEmpty(currency) ) {
			return "ISK";
		} else {
			return currency;
		}
	}
}
