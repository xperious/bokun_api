package is.bokun.dtos.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.booking.BookingDetailsDto;

/**
 * Created by ogg on 4/2/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ChargeResponseDto {

    public ChargeDto charge;
    public BookingDetailsDto booking;

    public ChargeDto getCharge() {
        return charge;
    }

    public void setCharge(ChargeDto charge) {
        this.charge = charge;
    }

    public BookingDetailsDto getBooking() {
        return booking;
    }

    public void setBooking(BookingDetailsDto booking) {
        this.booking = booking;
    }
}
