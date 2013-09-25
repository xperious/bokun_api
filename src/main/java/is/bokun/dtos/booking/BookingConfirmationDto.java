package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingConfirmationDto {

	public List<BookingPaymentInfoDto> payments = new ArrayList<>();
	
	public List<BookingFieldDto> bookingFields = new ArrayList<>();

	public List<BookingPaymentInfoDto> getPayments() {
		return payments;
	}

	public void setPayments(List<BookingPaymentInfoDto> payments) {
		this.payments = payments;
	}

	public List<BookingFieldDto> getBookingFields() {
		return bookingFields;
	}

	public void setBookingFields(List<BookingFieldDto> bookingFields) {
		this.bookingFields = bookingFields;
	}
}
