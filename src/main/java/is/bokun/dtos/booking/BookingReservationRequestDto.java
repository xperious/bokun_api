package is.bokun.dtos.booking;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.payments.CardDto;
import is.bokun.dtos.payments.ChargeRequestDto;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingReservationRequestDto {

    public BookingAnswersDto answers;
    public boolean createPaymentsAutomatically;
    public List<BookingPaymentInfoDto> paymentInfos = new ArrayList<>();

    public List<BookingFieldDto> bookingFields = new ArrayList<>();
    
    public Double discountPercentage;
    public Double discountAmount;
    
    public boolean deposit;
    public Double depositPercentage;
    public Double depositAmount;

    public ChargeRequestDto chargeRequest;

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

	public boolean isDeposit() {
		return deposit;
	}

	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}

	public Double getDepositPercentage() {
		return depositPercentage;
	}

	public void setDepositPercentage(Double depositPercentage) {
		this.depositPercentage = depositPercentage;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
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

    public List<BookingFieldDto> getBookingFields() {
        return bookingFields;
    }

    public void setBookingFields(List<BookingFieldDto> bookingFields) {
        this.bookingFields = bookingFields;
    }

    public ChargeRequestDto getChargeRequest() {
        return chargeRequest;
    }

    public void setChargeRequest(ChargeRequestDto chargeRequest) {
        this.chargeRequest = chargeRequest;
    }
}
