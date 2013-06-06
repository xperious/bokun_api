package is.bokun.dtos.booking;

import is.bokun.dtos.VendorDto;
import is.bokun.dtos.carrental.CarRentalLocationDto;
import is.bokun.utils.DateUtils;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarRentalBookingDto extends ProductBookingDto {

	public Date startDate;
	public Date endDate;
	
	public int pickupHour;
	public int pickupMinute;
	public int dropoffHour;
	public int dropoffMinute;
	
	public CarRentalLocationDto pickupLocation;
	public CarRentalLocationDto dropoffLocation;
	
	public ProductInfoDto carRental;

	public List<CarBookingDto> carBookings = new ArrayList<>();

	@JsonIgnore
	public int getDayCount() {
		return DateUtils.getNightCount(startDate, endDate);
	}

	@JsonIgnore
	public Date getSortDate() {
		return startDate;
	}

	@Override
	public VendorDto getVendor() {
		return carRental.vendor;
	}
}
