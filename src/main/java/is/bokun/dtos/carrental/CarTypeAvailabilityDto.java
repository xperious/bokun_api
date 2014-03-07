package is.bokun.dtos.carrental;

import is.bokun.dtos.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarTypeAvailabilityDto extends AvailabilityDto {

		public Long carTypeId;
	

	public Long getCarTypeId() {
		return carTypeId;
	}
	public void setCarTypeId(Long carTypeId) {
		this.carTypeId = carTypeId;
	}

	
	
}
