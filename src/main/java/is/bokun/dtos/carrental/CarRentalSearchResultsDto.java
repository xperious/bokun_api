package is.bokun.dtos.carrental;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalSearchResultsDto {

	public List<CarRentalDto> carRentals = new ArrayList<>();
}
