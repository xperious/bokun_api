package is.bokun.dtos.accommodation;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.AvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationAvailabilityDto extends AvailabilityDto {

	public int price;
	public Long roomTypeId;
}
