package dtos.booking;

import java.util.*;

public class AccommodationBookingQuestionsDto {

	public BookingItemInfoDto accommodation;
	public Long bookingId;
	
	public List<BookingQuestionDto> questions = new ArrayList<BookingQuestionDto>();
	
	public List<RoomBookingQuestionsDto> roomBookings = new ArrayList<RoomBookingQuestionsDto>();
}
