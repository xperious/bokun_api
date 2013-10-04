package is.bokun.dtos.booking;

import is.bokun.dtos.ItemDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "carBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;
	public ItemDto carType;
	
	public int unitCount;
	public int unitPrice;
	
	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerDto> answers = new ArrayList<>();
	
	@XmlElementWrapper(name = "extraBookings")
	@XmlElement(name="extraBooking")
	public List<ExtraBookingDetailsDto> extras = new ArrayList<>();
	
	@XmlElementWrapper
	@XmlElement(name="field")
    public List<BookingFieldDto> bookingFields = new ArrayList<>();
}
