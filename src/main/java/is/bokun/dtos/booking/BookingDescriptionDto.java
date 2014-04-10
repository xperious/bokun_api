package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "bookingDescription")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookingDescriptionDto {

    public Long id;
    public String confirmationCode;
    public String externalBookingReference;
    public String customerName;

    public List<ProductBookingDescriptionDto> activityBookings;
    public List<ProductBookingDescriptionDto> accommodationBookings;
    public List<ProductBookingDescriptionDto> carRentalBookings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getExternalBookingReference() {
        return externalBookingReference;
    }

    public void setExternalBookingReference(String externalBookingReference) {
        this.externalBookingReference = externalBookingReference;
    }

    public List<ProductBookingDescriptionDto> getActivityBookings() {
        return activityBookings;
    }

    public void setActivityBookings(List<ProductBookingDescriptionDto> activityBookings) {
        this.activityBookings = activityBookings;
    }

    public List<ProductBookingDescriptionDto> getAccommodationBookings() {
        return accommodationBookings;
    }

    public void setAccommodationBookings(List<ProductBookingDescriptionDto> accommodationBookings) {
        this.accommodationBookings = accommodationBookings;
    }

    public List<ProductBookingDescriptionDto> getCarRentalBookings() {
        return carRentalBookings;
    }

    public void setCarRentalBookings(List<ProductBookingDescriptionDto> carRentalBookings) {
        this.carRentalBookings = carRentalBookings;
    }
}
