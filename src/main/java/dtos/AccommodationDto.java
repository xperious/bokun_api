package dtos;

import java.util.List;
import java.util.Set;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;


public class AccommodationDto extends ProductDto {

	public int rating;
	
	@CollectionProperty(translation = "typesAsStrings") 
	public Set<String> types;
	
	@Property(translate = true)
	public LocationDto location;
	
	@CollectionProperty(itemTranslation = RoomTypeDto.class)
	public List<RoomTypeDto> roomTypes;
	
	@CollectionProperty(itemTranslation = AccommodationExtraDto.class)
	public List<AccommodationExtraDto> extras;
	
	public AccommodationDto() {
		super();
	}
}