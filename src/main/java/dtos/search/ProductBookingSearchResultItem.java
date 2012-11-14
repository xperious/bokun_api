package dtos.search;

import java.util.Date;

import dtos.booking.BookingItemInfoDto;

public class ProductBookingSearchResultItem {

	public BookingItemInfoDto channel;
	public BookingItemInfoDto product;
	public BookingItemInfoDto vendor;
	
	public Date creationDate;
	public String productType;
	public int totalPrice;
	public Date startDate, endDate;
}
