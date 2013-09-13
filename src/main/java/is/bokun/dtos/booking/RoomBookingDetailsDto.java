package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "RoomBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomBookingDetailsDto {

	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	public List<BookingAnswerDto> answers = new ArrayList<BookingAnswerDto>();
	public List<ExtraBookingDetailsDto> extras = new ArrayList<ExtraBookingDetailsDto>();
}
