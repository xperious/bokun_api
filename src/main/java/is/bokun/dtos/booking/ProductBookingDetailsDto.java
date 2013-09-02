package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.*;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBookingDetailsDto {

    public Long bookingId;
    public String title;
    public int totalPrice;
    public String productCategory;
    public PaymentPaidTypeEnum paidType;
    
    public Long productId;
    public String availabilityProductId;

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

    public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
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
    
    public PaymentPaidTypeEnum getPaidType() {
		return paidType;
	}

	public void setPaidType(PaymentPaidTypeEnum paidType) {
		this.paidType = paidType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getAvailabilityProductId() {
		return availabilityProductId;
	}

	public void setAvailabilityProductId(String availabilityProductId) {
		this.availabilityProductId = availabilityProductId;
	}

	@JsonIgnore
    public BookingPaymentInfoDto createAmountPayment(PaymentPaidTypeEnum paidType, PaymentTypeEnum paymentType, Double amount, String currency) {
		BookingPaymentInfoDto p = new BookingPaymentInfoDto();
		p.bookingId = getBookingId();
		p.productCategory = getProductCategory();
		p.bookingPaidType = paidType.name();
		p.paymentType = paymentType.name();
		p.currency = currency;
		p.amount = amount;
		p.confirmed = true;
		return p;
    }
    
}
