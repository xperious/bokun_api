package dtos.accommodation;

import java.util.*;

import com.codiform.moo.annotation.*;

import dtos.*;

public class RoomTypeDto {

	public Long id;
	public String externalId;
	public String title;
	
	@Property(translation = "accommodationType.name()")
    public String accommodationType;
	
    public String spaceType;
	
	public int capacity = 1;

    public boolean stayRestrictions = false;
	public int minNightsStay = 1;
	public int maxNightsStay = 30;
	
	public int roomCount = 1;
	
	public int singleBedCount = 0;
	public int doubleBedCount = 0;
	public int sofaBedCount = 0;

	public boolean shared = false;
	
	@Property(translation = "pricingType.name()")
	public String pricingType;

	public boolean singleOccupancyDiscountEnabled = false;
	public int singleOccupancyDiscount = 0;
	
	@CollectionProperty(optionality = Optionality.OPTIONAL)
	public List<TagGroupDto> tags = new ArrayList<TagGroupDto>();
	
	@CollectionProperty(optionality = Optionality.OPTIONAL)
	public List<PhotoDto> photos = new ArrayList<PhotoDto>();
	
	@CollectionProperty(optionality = Optionality.OPTIONAL)
	public List<AccommodationExtraDto> extras = new ArrayList<AccommodationExtraDto>();
	
	public List<AccommodationExtraDto> getIncludedExtras() {
		List<AccommodationExtraDto> list = new ArrayList<AccommodationExtraDto>();
		for ( AccommodationExtraDto e : extras ) {
			if ( e.mandatory ) {
				list.add(e);
			}
		}
		return list;
	}
	
	public List<AccommodationExtraDto> getOptionalExtras() {
		List<AccommodationExtraDto> list = new ArrayList<AccommodationExtraDto>();
		for ( AccommodationExtraDto e : extras ) {
			if ( !e.mandatory ) {
				list.add(e);
			}
		}
		return list;
	}
}
