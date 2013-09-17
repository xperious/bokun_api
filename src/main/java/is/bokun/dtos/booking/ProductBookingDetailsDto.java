package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.*;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "productBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBookingDetailsDto {

	@XmlElement(name = "id")
    public Long bookingId;
	public Long parentBookingId;
	
	public String confirmationCode;
	
	@XmlTransient
    public String title;
	
    public int totalPrice;
    
    @XmlTransient
    public String productCategory;
    
    public PaymentPaidTypeEnum paidType;
    
    public ProductInfoDto product = new ProductInfoDto();
    
    @XmlTransient
    public Long productId;
    public String availabilityProductId;

	@XmlElementWrapper
	@XmlElement(name="answer")
    public List<BookingAnswerDto> answers = new ArrayList<>();
    
	@XmlElementWrapper
	@XmlElement(name="payment")
    public List<PaymentDto> payments = new ArrayList<>();

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getParentBookingId() {
		return parentBookingId;
	}

	public void setParentBookingId(Long parentBookingId) {
		this.parentBookingId = parentBookingId;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
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
