package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "bookingbatch")
@XmlType(name = "bookingbatch")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingBatchDto {

    @XmlElementWrapper
    @XmlElement(name="booking")
    public List<BookingDetailsDto> bookings = new ArrayList<>();

    public List<BookingDetailsDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDetailsDto> bookings) {
        this.bookings = bookings;
    }
}
