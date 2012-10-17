package dtos.booking;

import java.util.*;

import dtos.accommodation.AccommodationDto;

public class AccommodationBookingDto {

	public Long id;
	
	public Date creationDate;
	public Date lastModifedDate;

    public Date startDate;
    public Date endDate;
    
    public String userUuid;
    public AccommodationDto accommodation;
    
    public String bookingStatus;
    
    public int totalPrice;
    
    public List<RoomBookingDto> roomBookings = new ArrayList<RoomBookingDto>();
}
