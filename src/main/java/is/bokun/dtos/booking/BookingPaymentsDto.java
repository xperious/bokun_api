package is.bokun.dtos.booking;

import java.util.*;

public class BookingPaymentsDto {

	public List<BookingPaymentInfoDto> payments = new ArrayList<>();

	public List<BookingPaymentInfoDto> getPayments() {
		return payments;
	}

	public void setPayments(List<BookingPaymentInfoDto> payments) {
		this.payments = payments;
	}
}
