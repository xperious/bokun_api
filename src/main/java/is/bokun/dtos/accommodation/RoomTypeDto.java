package is.bokun.dtos.accommodation;

import is.bokun.dtos.*;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class RoomTypeDto implements WithExtras {

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
	
	public List<BookableExtraDto> extras = new ArrayList<>();

    @JsonIgnore
	public BookableExtraDto findExtra(Long id) {
		for (BookableExtraDto e : extras) {
			if ( e.id.equals(id) ) {
				return e;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public List<BookableExtraDto> getIncludedExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( e.included ) {
				list.add(e);
			}
		}
		return list;
	}
	
	@JsonIgnore
	public List<BookableExtraDto> getOptionalExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( !e.included ) {
				list.add(e);
			}
		}
		return list;
	}
}
