package dtos.accommodation;

import java.util.*;

import com.codiform.moo.annotation.*;

import dtos.*;


public class AccommodationDto extends ProductDto {

	public int rating;
	 
	public Set<String> types = new HashSet<String>();
	
	@Property(translate = true)
	public LocationDto location;
	
	@CollectionProperty(itemTranslation = RoomTypeDto.class)
	public List<RoomTypeDto> roomTypes = new ArrayList<RoomTypeDto>();
	
	@CollectionProperty(itemTranslation = AccommodationExtraDto.class)
	public List<AccommodationExtraDto> bookableExtras = new ArrayList<AccommodationExtraDto>();
	
	public AccommodationAvailabilityReportDto availabilityReport;
	
	public AccommodationDto() {
		super();
	}
}