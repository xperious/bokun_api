package is.bokun.dtos.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.AvailabilityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "accommodationAvailability")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccommodationAvailabilityDto extends AvailabilityDto {

	public Long roomTypeId;

	public Long getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	
}
