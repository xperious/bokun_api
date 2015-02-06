package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingConfirmationDto {

	public BookingPaymentInfoDto payment;
	
	public List<BookingFieldDto> bookingFields = new ArrayList<>();

	public BookingPaymentInfoDto getPayment() {
		return payment;
	}

	public void setPayment(BookingPaymentInfoDto payment) {
		this.payment = payment;
	}

	public List<BookingFieldDto> getBookingFields() {
		return bookingFields;
	}

	public void setBookingFields(List<BookingFieldDto> bookingFields) {
		this.bookingFields = bookingFields;
	}
}
