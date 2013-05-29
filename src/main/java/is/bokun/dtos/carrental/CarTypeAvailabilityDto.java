package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityDto extends AvailabilityDto {

	public int price;
	public ItemDto carType;
}
