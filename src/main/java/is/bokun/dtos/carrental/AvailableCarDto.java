package is.bokun.dtos.carrental;

import is.bokun.dtos.AvailabilityInfoDto;
import is.bokun.queries.CarQuery;

import java.util.*;

public class AvailableCarDto {

	public Long id;
	public int totalPrice;
	public int maxBookableCount;
	
	public CarTypeDto carType;
	
	public List<AvailabilityInfoDto> availabilities = new ArrayList<AvailabilityInfoDto>();
	
	public AvailableCarDto() {}

    public AvailableCarDto(Long id, int totalPrice, int availableAcrossInterval, CarTypeDto carType, CarQuery query) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.carType = carType;
        this.maxBookableCount = availableAcrossInterval;
	}
}
