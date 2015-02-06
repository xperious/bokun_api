package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Sindri Traustason
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "settlement")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SettlementDto {

    public Long bookingId;
    public String productCategory;
    public String bookingPaidType;
    public Double amount;
    public PaymentDto payment;

    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingPaidType() {
        return bookingPaidType;
    }
    public void setBookingPaidType(String bookingPaidType) {
        this.bookingPaidType = bookingPaidType;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentDto getPayment() {
        return payment;
    }
    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }
}
