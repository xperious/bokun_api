package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityDto extends AvailabilityDto {

	public int price;
	public ItemDto carType;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ItemDto getCarType() {
		return carType;
	}
	public void setCarType(ItemDto carType) {
		this.carType = carType;
	}
	
	
}
