package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentDto {

    public CustomerPaymentDto(Double amount, String currency, String paymentReferenceId, PaymentTypeEnum paymentType) {
        this.amount = amount;
        this.currency = currency;
        this.paymentReferenceId = paymentReferenceId;
        this.paymentType = paymentType;
    }

    private Double amount;
    private String currency;
    private String paymentReferenceId;
    private PaymentTypeEnum paymentType;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }
}
