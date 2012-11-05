package dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class RoomBookingDto {

	public Long id;
	
	public BookingItemInfoDto roomType;
	
	public String guestFirstName;
	public String guestLastName;

    public Date startDate;
    public Date endDate;
	
    public int unitCount;

	public String specialRequests;
	
	public boolean unavailable;
	public int availabilityCount;
	public int roomPrice;
	public int extrasPrice;
	
	public List<AccommodationExtraBookingDto> extraBookings = new ArrayList<AccommodationExtraBookingDto>();
	
	public List<AccommodationAvailabilityBookingDto> availabilityBookings = new ArrayList<AccommodationAvailabilityBookingDto>();
	
	@JsonIgnore
    public List<AccommodationExtraBookingDto> getExtraBookings(boolean included) {
        List<AccommodationExtraBookingDto> list = new ArrayList<AccommodationExtraBookingDto>();
        for ( AccommodationExtraBookingDto ae : extraBookings ) {
            if ( (ae.included && included) || (!ae.included && !included) ) {
                list.add(ae);
            }
        }
        return list;
    }

}
