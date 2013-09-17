package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "ExtraBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	public String title;
	public int unitCount;
	public int unitPrice;
	
	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerWithIdDto> answers = new ArrayList<BookingAnswerWithIdDto>();
}
