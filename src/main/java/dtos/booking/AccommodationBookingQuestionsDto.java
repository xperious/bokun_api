package dtos.booking;

import java.util.*;

public class AccommodationBookingQuestionsDto {

	public BookingItemInfoDto accommodation;
	public Long bookingId;
	public Date startDate, endDate;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<BookingQuestionGroupDto>();
	
	public List<RoomBookingQuestionsDto> roomBookings = new ArrayList<RoomBookingQuestionsDto>();
}
