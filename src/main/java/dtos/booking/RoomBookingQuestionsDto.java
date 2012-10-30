package dtos.booking;

import java.util.*;

public class RoomBookingQuestionsDto {

	public BookingItemInfoDto roomType;
	public Long bookingId;
	
	public List<BookingQuestionDto> questions = new ArrayList<BookingQuestionDto>();
	public List<ExtraBookingQuestionsDto> extraBookings = new ArrayList<ExtraBookingQuestionsDto>();
}
