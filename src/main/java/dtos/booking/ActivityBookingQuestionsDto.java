package dtos.booking;

import java.util.*;

public class ActivityBookingQuestionsDto {

	public BookingItemInfoDto activity;
	public Long bookingId;
	
	public List<BookingQuestionDto> questions = new ArrayList<BookingQuestionDto>();
	
	public List<ExtraBookingQuestionsDto> extraBookings = new ArrayList<ExtraBookingQuestionsDto>();
}
