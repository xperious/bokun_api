package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PickupPricingTypeEnum {

	FREE,
	PER_BOOKING,
	PER_PERSON;
}
