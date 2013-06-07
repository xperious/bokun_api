package is.bokun.dtos.booking;

import java.util.*;

public class CarBookingDetailsDto {

	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<ExtraBookingDetailsDto> extras = new ArrayList<ExtraBookingDetailsDto>();
}
