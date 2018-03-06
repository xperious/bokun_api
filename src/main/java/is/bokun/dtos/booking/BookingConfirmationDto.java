package is.bokun.dtos.booking;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingConfirmationDto {

//	public BookingPaymentInfoDto payment;

	public String externalBookingReference;

	public CustomerPaymentDto payment;

	public List<BookingFieldDto> bookingFields = new ArrayList<>();

//	public BookingPaymentInfoDto getPayment() {
//		return payment;
//	}
//

//	public void setPayment(BookingPaymentInfoDto payment) {
//		this.payment = payment;
//	}

	public CustomerPaymentDto getPayment() {
		return payment;
	}

	public void setPayment(CustomerPaymentDto payment) {
		this.payment = payment;
	}

	public List<BookingFieldDto> getBookingFields() {
		return bookingFields;
	}

	public void setBookingFields(List<BookingFieldDto> bookingFields) {
		this.bookingFields = bookingFields;
	}

	public String getExternalBookingReference() {
		return externalBookingReference;
	}

	public void setExternalBookingReference(String externalBookingReference) {
		this.externalBookingReference = externalBookingReference;
	}
}
