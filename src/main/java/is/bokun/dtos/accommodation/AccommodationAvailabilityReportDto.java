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

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public List<AvailableRoomDto> getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(List<AvailableRoomDto> availableRooms) {
		this.availableRooms = availableRooms;
	}

	public int getNightCount() {
		return nightCount;
	}

	public void setNightCount(int nightCount) {
		this.nightCount = nightCount;
	}
}
