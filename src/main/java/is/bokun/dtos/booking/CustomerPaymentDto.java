package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentDto {

    public CustomerPaymentDto() {}

    public CustomerPaymentDto(Double amount, String currency, String paymentReferenceId, PaymentTypeEnum paymentType) {
        this.amount = amount;
        this.currency = currency;
        this.paymentReferenceId = paymentReferenceId;
        this.paymentType = paymentType;
    }

    private Double amount;
    private String currency;
    private String paymentReferenceId;
    private String authorizationCode;
    private String comment;
    private PaymentTypeEnum paymentType;
    private String paymentProviderType;
    private String cardBrand;
    private String cardNumber;

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

    public void setAuthorizationCode(String authorizationCode) { this.authorizationCode = authorizationCode; }

    public String getAuthorizationCode() { return this.authorizationCode; }

    public void setComment(String comment) { this.comment = comment; }

    public String getComment() { return this.comment; }

    public void setPaymentProviderType(String paymentProviderType) { this.paymentProviderType = paymentProviderType; }

    public String getPaymentProviderType() { return this.paymentProviderType; }


    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
