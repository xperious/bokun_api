package is.bokun.dtos.booking;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.VendorDto;
import is.bokun.dtos.carrental.CarRentalLocationDto;
import is.bokun.utils.DateUtils;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CarRentalBookingDto extends ProductBookingDto {

	public Date startDate;
	public Date endDate;
    public int dayCount;


    public CarRentalLocationDto pickupLocation;
	public CarRentalLocationDto dropoffLocation;
	
	public ProductInfoDto carRental;

	public List<CarBookingDto> carBookings = new ArrayList<>();

    @JsonIgnore
	public int getDayCount() {
		return DateUtils.getRentalDayCount(startDate, endDate);
	}

	@JsonIgnore
	public Date getSortDate() {
		return startDate;
	}

	@Override
	public VendorDto getVendor() {
		return carRental.vendor;
	}
	
	@Override
	public String getProductCategory() {
		return "CAR_RENTALS";
	}

    public List<CarBookingDto> getCarBookings() {
        return carBookings;
    }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public CarRentalLocationDto getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(CarRentalLocationDto pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public CarRentalLocationDto getDropoffLocation() {
		return dropoffLocation;
	}

	public void setDropoffLocation(CarRentalLocationDto dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	public ProductInfoDto getCarRental() {
		return carRental;
	}

	public void setCarRental(ProductInfoDto carRental) {
		this.carRental = carRental;
	}

	public void setCarBookings(List<CarBookingDto> carBookings) {
		this.carBookings = carBookings;
	}

}
