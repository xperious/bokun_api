package is.bokun.dtos.accommodation;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.utils.DateUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationAvailabilityReportDto {

	public Date checkInDate, checkOutDate;
	public List<AvailableRoomDto> availableRooms;
	public int nightCount;
	
	public int numberOfNights() {
		return DateUtils.getNightCount(checkInDate, checkOutDate);
	}
	
	public AvailableRoomDto findAvailableRoom(Long roomTypeId) {
		for (AvailableRoomDto room : availableRooms) {
			if ( room.roomType.id.equals(roomTypeId) ) {
				return room;
			}
		}
		return null;
	}
}
