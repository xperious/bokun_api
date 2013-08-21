package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum ProductCategoryEnum {

	ACCOMMODATION,
	ACTIVITIES,
	CAR_RENTALS
}
