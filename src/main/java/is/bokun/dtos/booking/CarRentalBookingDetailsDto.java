package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarRentalLocationDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "CarRentalBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRentalBookingDetailsDto extends ProductBookingDetailsDto {

	public Date startDate, endDate;
	public CarRentalLocationDto pickupLocation, dropoffLocation; 
	
	@XmlElementWrapper(name="carBookings")
	@XmlElement(name="carBooking")
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
