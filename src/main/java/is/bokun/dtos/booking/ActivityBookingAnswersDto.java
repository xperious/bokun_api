package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityBookingAnswersDto {

	public Long bookingId;
	
	public Long pickupPlaceId;
	public String pickupPlaceDescription;
	public String pickupPlaceRoomNumber;
	
	public Long dropoffPlaceId;
	public String dropoffPlaceDescription;
	
	public List<BookingAnswerGroupDto> answerGroups = new ArrayList<BookingAnswerGroupDto>();
	public List<ExtraBookingAnswersDto> extraBookings = new ArrayList<ExtraBookingAnswersDto>();
	
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public List<BookingAnswerGroupDto> getAnswerGroups() {
		return answerGroups;
	}
	public void setAnswerGroups(List<BookingAnswerGroupDto> answerGroups) {
		this.answerGroups = answerGroups;
	}
	public List<ExtraBookingAnswersDto> getExtraBookings() {
		return extraBookings;
	}
	public void setExtraBookings(List<ExtraBookingAnswersDto> extraBookings) {
		this.extraBookings = extraBookings;
	}
	
	@JsonIgnore
	public void setPickupInfo(Long pickupPlaceId, String pickupPlaceDescription, String pickupRoomNumber) {
		this.pickupPlaceId = pickupPlaceId;
		this.pickupPlaceDescription = pickupPlaceDescription;
		this.pickupPlaceRoomNumber = pickupRoomNumber;
	}
	
	@JsonIgnore
	public void setDropoffInfo(Long dropoffPlaceId, String dropoffPlaceDescription) {
		this.dropoffPlaceId = dropoffPlaceId;
		this.dropoffPlaceDescription = dropoffPlaceDescription;
	}
	
}
