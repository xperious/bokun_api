package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "ExtraBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraBookingDetailsDto {

	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	public List<BookingAnswerWithIdDto> answers = new ArrayList<BookingAnswerWithIdDto>();
}
