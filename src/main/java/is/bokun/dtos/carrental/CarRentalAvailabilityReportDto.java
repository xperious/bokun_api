package is.bokun.dtos.carrental;

import is.bokun.utils.DateUtils;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalAvailabilityReportDto {

	public Date pickupDate, dropoffDate;
	public List<AvailableCarDto> availableCars;
	public int dayCount;
	
	public int numberOfDays() {
		return DateUtils.getRentalDayCount(pickupDate, dropoffDate);
	}
	
	public int lowestTotalPrice() {
		int price = -1;
		for (AvailableCarDto car : availableCars) {
			if ( price == -1 || car.totalPrice < price ) {
				price = car.totalPrice;
			}
		}
		return price;
	}
	
	public AvailableCarDto findAvailableCar(Long carTypeId) {
		for (AvailableCarDto car : availableCars) {
			if ( car.carType.id.equals(carTypeId) ) {
				return car;
			}
		}
		return null;
	}
}
