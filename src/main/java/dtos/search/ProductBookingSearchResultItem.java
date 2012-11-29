package dtos.search;

import java.util.Date;

import utils.StringUtils;

import dtos.booking.BookingItemInfoDto;

public class ProductBookingSearchResultItem {

	public Long id;
	public String confirmationCode;
	
	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public BookingItemInfoDto vendor;
	public BookingItemInfoDto seller;
	
	public Date creationDate;
	public String productType;
	public int totalPrice;
	public String currency;
	public Date startDate, endDate;
	
	public String getCurrency() {
		if ( StringUtils.isNullOrEmpty(currency) ) {
			return "ISK";
		} else {
			return currency;
		}
	}
}
