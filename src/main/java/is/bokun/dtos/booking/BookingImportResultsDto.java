package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookingImportResultsDto {

    public Boolean success;

    public Integer bookingLineNumber;
    public Integer productBookingLineNumber;
    public String errorMsg;

    public List<BookingDescriptionDto> importedBookings = new ArrayList<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getBookingLineNumber() {
        return bookingLineNumber;
    }

    public void setBookingLineNumber(Integer bookingLineNumber) {
        this.bookingLineNumber = bookingLineNumber;
    }

    public Integer getProductBookingLineNumber() {
        return productBookingLineNumber;
    }

    public void setProductBookingLineNumber(Integer productBookingLineNumber) {
        this.productBookingLineNumber = productBookingLineNumber;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<BookingDescriptionDto> getImportedBookings() {
        return importedBookings;
    }

    public void setImportedBookings(List<BookingDescriptionDto> importedBookings) {
        this.importedBookings = importedBookings;
    }
}
