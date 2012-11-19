package dtos.booking;

import java.util.*;

public class RoomBookingQuestionsDto {

	public BookingItemInfoDto roomType;
	public Long bookingId;
	public int unitCount;
	
	public List<BookingQuestionGroupDto> questions = new ArrayList<BookingQuestionGroupDto>();
	public List<ExtraBookingQuestionsDto> extraBookings = new ArrayList<ExtraBookingQuestionsDto>();
}
