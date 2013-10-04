package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BookingStatusEnum {

    CART,
    RESERVED,
    CONFIRMED,
    TIMEOUT,
    ABORTED,
    CANCELLED,
    ERROR
}
