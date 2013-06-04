package is.bokun.dtos.accommodation;

import is.bokun.dtos.*;

import java.util.*;

public class RoomTypeDto extends HasBookableExtras {

	public Long id;
	public String externalId;
	public String title;
	
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
	
	public String pricingType;

	public boolean singleOccupancyDiscountEnabled = false;
	public int singleOccupancyDiscount = 0;
	
	public List<TagGroupDto> tags = new ArrayList<>();
	
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	

}
