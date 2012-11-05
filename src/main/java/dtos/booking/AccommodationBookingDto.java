package dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import dtos.accommodation.AccommodationDto;

public class AccommodationBookingDto extends ProductBookingDto {

    public Date startDate;
    public Date endDate;
    
    public ProductInfoDto accommodation;
    
    public List<RoomBookingDto> roomBookings = new ArrayList<RoomBookingDto>();
    
    @JsonIgnore
    public Date getSortDate() {
    	return startDate;
    }
}
