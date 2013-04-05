package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class BookingReservationRequestDto {

    public BookingAnswersDto answers;
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
}
