package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
