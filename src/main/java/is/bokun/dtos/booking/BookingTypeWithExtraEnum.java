package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BookingTypeWithExtraEnum {

	ROOM_BOOKING,
	ACTIVITY_BOOKING,
	CAR_BOOKING
}
