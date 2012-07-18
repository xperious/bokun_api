package dtos.accommodation;

import java.util.Date;
import java.util.List;

public class AccommodationAvailabilityReportDto {

	public Date checkInDate, checkOutDate;
	public List<AvailableRoomDto> availableRooms;
}
