package is.bokun.dtos.carrental;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalSearchResultsDto {

	public List<CarRentalDto> carRentals = new ArrayList<>();

	public List<CarRentalDto> getCarRentals() {
		return carRentals;
	}

	public void setCarRentals(List<CarRentalDto> carRentals) {
		this.carRentals = carRentals;
	}
}
