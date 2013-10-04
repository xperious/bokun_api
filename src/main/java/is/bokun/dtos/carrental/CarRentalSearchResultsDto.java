package is.bokun.dtos.carrental;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalSearchResultsDto {

	public List<CarRentalDto> carRentals = new ArrayList<>();
}
