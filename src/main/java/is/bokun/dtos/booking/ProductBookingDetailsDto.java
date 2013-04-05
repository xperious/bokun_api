package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class ProductBookingDetailsDto {

    public Long bookingId;
    public String title;
    public int totalPrice;

    public List<BookingAnswerDto> answers = new ArrayList<>();
    public List<PaymentDto> payments = new ArrayList<>();

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<BookingAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<BookingAnswerDto> answers) {
        this.answers = answers;
    }

    public List<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDto> payments) {
        this.payments = payments;
    }
}
