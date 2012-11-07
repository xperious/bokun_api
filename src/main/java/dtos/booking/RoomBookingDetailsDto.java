package dtos.booking;

import java.util.*;

public class RoomBookingDetailsDto {

	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<ExtraBookingDetailsDto> extras = new ArrayList<ExtraBookingDetailsDto>();
}
