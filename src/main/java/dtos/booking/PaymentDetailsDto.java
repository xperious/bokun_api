package dtos.booking;

import java.util.Date;

public class PaymentDetailsDto {

	public String paymentProvider;
	
	public String externalTransactionId;
	public Date transactionDate;
	
	public String cardBrand;
	public String cardNumberLastFour;
	
	public String fullName;
	public String address;
	public String postCode;
	public String place;
	public String country;
	public String emailAddress;
	
	public String getPaymentProvider() {
		return paymentProvider;
	}
	public void setPaymentProvider(String paymentProvider) {
		this.paymentProvider = paymentProvider;
	}
	public String getExternalTransactionId() {
		return externalTransactionId;
	}
	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getCardBrand() {
		return cardBrand;
	}
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}
	public String getCardNumberLastFour() {
		return cardNumberLastFour;
	}
	public void setCardNumberLastFour(String cardNumberLastFour) {
		this.cardNumberLastFour = cardNumberLastFour;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
