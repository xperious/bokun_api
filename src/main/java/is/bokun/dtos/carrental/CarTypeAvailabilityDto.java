package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityDto extends AvailabilityDto {

	public int price;
	public Long carTypeId;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(Long carTypeId) {
		this.carTypeId = carTypeId;
	}

	
	
}
