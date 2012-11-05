package dtos.booking;


public class AccommodationExtraBookingDto {

	public Long id;
	
	public BookingItemInfoDto extra;
	public boolean included;
	
	public String description;

	public int unitCount;
	public int bookedPrice;
	public String pricingType;
}
