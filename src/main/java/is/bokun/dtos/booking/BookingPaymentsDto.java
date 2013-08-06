package is.bokun.dtos.booking;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPaymentsDto {

	public List<BookingPaymentInfoDto> payments = new ArrayList<>();

	public List<BookingPaymentInfoDto> getPayments() {
		return payments;
	}

	public void setPayments(List<BookingPaymentInfoDto> payments) {
		this.payments = payments;
	}
}
