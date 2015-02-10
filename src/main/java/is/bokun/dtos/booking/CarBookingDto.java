package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarTypeInfoDto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarBookingDto {

	public Long id;
	
	public CarTypeInfoDto carType;

    public Date startDate;
    public Date endDate;
	
    public int unitCount;
	
	public boolean unavailable;
	public int availabilityCount;
	public double carPrice;
	public int extrasPrice;
	public int locationPrice;
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	public List<CarTypeAvailabilityBookingDto> availabilityBookings = new ArrayList<>();
	
	@JsonIgnore
    public List<ExtraBookingDto> getExtraBookingsByIncluded(boolean included) {
        List<ExtraBookingDto> list = new ArrayList<>();
        for ( ExtraBookingDto ae : extraBookings ) {
            if ( (ae.included && included) || (!ae.included && !included) ) {
                list.add(ae);
            }
        }
        return list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarTypeInfoDto getCarType() {
        return carType;
    }

    public void setCarType(CarTypeInfoDto carType) {
        this.carType = carType;
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

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }

    public boolean isUnavailable() {
        return unavailable;
    }

    public void setUnavailable(boolean unavailable) {
        this.unavailable = unavailable;
    }

    public int getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(int availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getExtrasPrice() {
        return extrasPrice;
    }

    public void setExtrasPrice(int extrasPrice) {
        this.extrasPrice = extrasPrice;
    }

    public int getLocationPrice() {
        return locationPrice;
    }

    public void setLocationPrice(int locationPrice) {
        this.locationPrice = locationPrice;
    }

    public List<ExtraBookingDto> getExtraBookings() {
        return extraBookings;
    }

    public void setExtraBookings(List<ExtraBookingDto> extraBookings) {
        this.extraBookings = extraBookings;
    }

    public List<CarTypeAvailabilityBookingDto> getAvailabilityBookings() {
        return availabilityBookings;
    }

    public void setAvailabilityBookings(List<CarTypeAvailabilityBookingDto> availabilityBookings) {
        this.availabilityBookings = availabilityBookings;
    }
}
