package dtos;

import java.util.List;
import java.util.Set;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

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
	
	public Set<Long> tags;
	
	@CollectionProperty(translation = "photos()")
	public Set<Long> photoIds;
	
	@CollectionProperty(translation = "extras()")
	public Set<Long> extraIds;
}
