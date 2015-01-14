package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomBookingDto {

	public Long id;
	
	public BookingItemInfoDto roomType;

    public Date startDate;
    public Date endDate;
	
    public int unitCount;
	
	public boolean unavailable;
	public int availabilityCount;
	public Double roomPrice;
	public Double extrasPrice;
	
	public List<ExtraBookingDto> extraBookings = new ArrayList<>();
	
	public List<AccommodationAvailabilityBookingDto> availabilityBookings = new ArrayList<>();
	
	@JsonIgnore
    public List<ExtraBookingDto> getExtraBookings(boolean included) {
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

    public BookingItemInfoDto getRoomType() {
        return roomType;
    }

    public void setRoomType(BookingItemInfoDto roomType) {
        this.roomType = roomType;
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

    public Double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Double getExtrasPrice() {
        return extrasPrice;
    }

    public void setExtrasPrice(Double extrasPrice) {
        this.extrasPrice = extrasPrice;
    }

    public List<ExtraBookingDto> getExtraBookings() {
        return extraBookings;
    }

    public void setExtraBookings(List<ExtraBookingDto> extraBookings) {
        this.extraBookings = extraBookings;
    }

    public List<AccommodationAvailabilityBookingDto> getAvailabilityBookings() {
        return availabilityBookings;
    }

    public void setAvailabilityBookings(List<AccommodationAvailabilityBookingDto> availabilityBookings) {
        this.availabilityBookings = availabilityBookings;
    }
}
