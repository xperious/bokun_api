package dtos;

import com.codiform.moo.annotation.Property;

public class AccommodationExtraDto {

	public Long id;
	public String description;
	public boolean mandatory;

	public boolean active = true;

	public boolean freeOfCharge;
	public int price;
	
	@Property(translation = "pricingType.name()")
	public String pricingType;
}
