package is.bokun.dtos.activity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PickupPricingTypeEnum {

	FREE,
	PER_BOOKING,
	PER_PERSON;
}
