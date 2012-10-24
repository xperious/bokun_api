package dtos.booking;

import java.util.*;

import dtos.accommodation.AccommodationDto;

public class AccommodationBookingDto extends ProductBookingDto {

    public Date startDate;
    public Date endDate;
    
    public AccommodationDto accommodation;
    
    public List<RoomBookingDto> roomBookings = new ArrayList<RoomBookingDto>();
    
    public Date getSortDate() {
    	return startDate;
    }
}
