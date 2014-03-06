package is.bokun.dtos.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.AvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationAvailabilityDto extends AvailabilityDto {

	public Long roomTypeId;

	public Long getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	
}
