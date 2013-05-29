package is.bokun.dtos.accommodation;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.AvailabilityDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccommodationAvailabilityDto extends AvailabilityDto {

	public int price;
	public Long roomTypeId;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	
	
}
