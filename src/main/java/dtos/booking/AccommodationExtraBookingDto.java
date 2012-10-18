package dtos.booking;

import dtos.accommodation.AccommodationExtraDto;

public class AccommodationExtraBookingDto {

	public Long id;
	
	public AccommodationExtraDto extra;
	
	public String description;

	public int unitCount;
	public int bookedPrice;
	public String pricingType;
}
