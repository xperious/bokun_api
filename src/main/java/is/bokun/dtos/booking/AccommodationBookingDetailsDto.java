package is.bokun.dtos.booking;

import java.util.*;

public class AccommodationBookingDetailsDto {

	public Long bookingId;
	public String title;
	public Date startDate, endDate;
	
	public int totalPrice;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<RoomBookingDetailsDto> rooms = new ArrayList<RoomBookingDetailsDto>();
}
