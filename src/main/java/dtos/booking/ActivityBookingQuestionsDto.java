package dtos.booking;

import java.util.*;

public class ActivityBookingQuestionsDto {

	public BookingItemInfoDto activity;
	public Long bookingId;
	public Date date;
	public String time;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<BookingQuestionGroupDto>();
	
	public List<ExtraBookingQuestionsDto> extraBookings = new ArrayList<ExtraBookingQuestionsDto>();
}
