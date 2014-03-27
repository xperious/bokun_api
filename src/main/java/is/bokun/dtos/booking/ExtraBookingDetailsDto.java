package is.bokun.dtos.booking;

import is.bokun.dtos.ItemDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "extraBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtraBookingDetailsDto {

	@XmlElement(name="id")
	public Long bookingId;
	@XmlTransient
	public String title;
	public ItemDto extra;
	
	public int unitCount;
	public int unitPrice;
	
	@XmlElementWrapper
	@XmlElement(name="answer")
	public List<BookingAnswerWithIdDto> answers = new ArrayList<>();
	
	public ExtraBookingDetailsDto() {}
	
	public ExtraBookingDetailsDto(Long bookingId, int unitCount, int unitPrice, ItemDto extra) {
		this.bookingId = bookingId;
		this.unitCount = unitCount;
		this.unitPrice = unitPrice;
		this.extra = extra;
		if ( extra != null ) {
			this.title = extra.title;
		}
	}
}
