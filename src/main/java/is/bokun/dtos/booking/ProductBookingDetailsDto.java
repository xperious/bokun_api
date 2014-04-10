package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
    public Double priceWithDiscount;
    
	public Double discountPercentage;
	public Double discountAmount;
    
    @XmlTransient
    public String productCategory;
    
    public PaymentPaidTypeEnum paidType;
    
    public ProductInfoDto product = new ProductInfoDto();
    
    @XmlTransient
    public Long productId;
    public String externalProductId;

	@XmlElementWrapper
	@XmlElement(name="answer")
    public List<BookingAnswerDto> answers = new ArrayList<>();
    
	@XmlElementWrapper
	@XmlElement(name="payment")
    public List<PaymentDto> payments = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="note")
    public List<BookingNoteDto> notes = new ArrayList<>();

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

    public Double getPriceWithDiscount() {
		return priceWithDiscount;
	}

	public void setPriceWithDiscount(Double priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
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

	public String getExternalProductId() {
		return externalProductId;
	}

	public void setExternalProductId(String externalProductId) {
		this.externalProductId = externalProductId;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }

    public List<BookingNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<BookingNoteDto> notes) {
        this.notes = notes;
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
