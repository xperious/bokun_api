package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum ProductCategoryEnum {

	ACCOMMODATION,
	ACTIVITIES,
	CAR_RENTALS,
    TRANSPORT
}
