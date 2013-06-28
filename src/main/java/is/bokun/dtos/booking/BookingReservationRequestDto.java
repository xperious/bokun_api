package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingReservationRequestDto {

    public BookingAnswersDto answers;
    public boolean createPaymentsAutomatically;
    public List<BookingPaymentInfoDto> paymentInfos = new ArrayList<>();

    public BookingAnswersDto getAnswers() {
        return answers;
    }

    public void setAnswers(BookingAnswersDto answers) {
        this.answers = answers;
    }

    public List<BookingPaymentInfoDto> getPaymentInfos() {
        return paymentInfos;
    }

    public void setPaymentInfos(List<BookingPaymentInfoDto> paymentInfos) {
        this.paymentInfos = paymentInfos;
    }

	public boolean isCreatePaymentsAutomatically() {
		return createPaymentsAutomatically;
	}

	public void setCreatePaymentsAutomatically(boolean createPaymentsAutomatically) {
		this.createPaymentsAutomatically = createPaymentsAutomatically;
	}
}
