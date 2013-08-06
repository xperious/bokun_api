package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BookingTypeWithExtraEnum {

	ROOM_BOOKING,
	ACTIVITY_BOOKING,
	CAR_BOOKING
}
