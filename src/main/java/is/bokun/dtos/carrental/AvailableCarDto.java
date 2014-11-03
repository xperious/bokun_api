package is.bokun.dtos.carrental;

import is.bokun.dtos.AvailabilityInfoDto;
import is.bokun.dtos.pricing.CostItemTypeEnum;
import is.bokun.queries.CarQuery;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableCarDto {

	public Long id;
	public double totalPrice;
	public int maxBookableCount;

    public Map<Long,Double> extraPrices = new HashMap<>();

	public CarTypeDto carType;
	
	public List<AvailabilityInfoDto> availabilities = new ArrayList<>();
	
	public AvailableCarDto() {}

    public AvailableCarDto(Long id, double totalPrice, int availableAcrossInterval, CarTypeDto carType, CarQuery query) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.carType = carType;
        this.maxBookableCount = availableAcrossInterval;
	}
}
