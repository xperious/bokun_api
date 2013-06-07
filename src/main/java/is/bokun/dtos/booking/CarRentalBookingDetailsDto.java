package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarRentalLocationDto;

import java.util.*;

public class CarRentalBookingDetailsDto extends ProductBookingDetailsDto {

	public Date startDate, endDate;
	public int pickupHour, pickupMinute, dropoffHour, dropoffMinute;
	public CarRentalLocationDto pickupLocation, dropoffLocation; 
	public List<CarBookingDetailsDto> cars = new ArrayList<>();

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

    public List<CarBookingDetailsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarBookingDetailsDto> cars) {
        this.cars = cars;
    }

	public int getPickupHour() {
		return pickupHour;
	}

	public void setPickupHour(int pickupHour) {
		this.pickupHour = pickupHour;
	}

	public int getPickupMinute() {
		return pickupMinute;
	}

	public void setPickupMinute(int pickupMinute) {
		this.pickupMinute = pickupMinute;
	}

	public int getDropoffHour() {
		return dropoffHour;
	}

	public void setDropoffHour(int dropoffHour) {
		this.dropoffHour = dropoffHour;
	}

	public int getDropoffMinute() {
		return dropoffMinute;
	}

	public void setDropoffMinute(int dropoffMinute) {
		this.dropoffMinute = dropoffMinute;
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
}
