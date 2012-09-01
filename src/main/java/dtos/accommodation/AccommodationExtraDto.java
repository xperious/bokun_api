package dtos.accommodation;

import java.util.*;

import com.codiform.moo.annotation.Property;

import dtos.QuestionDto;

public class AccommodationExtraDto {

	public Long id;
	public String externalId;
	public String title;
	public boolean mandatory;

	public boolean freeOfCharge;
	public int price;
	
	@Property(translation = "pricingType.name()")
	public String pricingType;
	
	public List<QuestionDto> questions = new ArrayList<QuestionDto>();
}
