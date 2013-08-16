package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPaymentInfoDto extends PaymentDto {

    public Long bookingId;
    public String productCategory;
    public String bookingPaidType;

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

}
