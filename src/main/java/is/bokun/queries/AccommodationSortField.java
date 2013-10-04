package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The available sort fields for Accommodation results.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AccommodationSortField {

	BEST_SELLING_GLOBAL,
	BEST_SELLING_IN_CHANNEL,
	PRICE,
	DISTANCE,
	ALPHABETIC,
	RANDOM;
	
	public String field() {
		switch (this) {
			case BEST_SELLING_GLOBAL:
				return "booking_count";
			case BEST_SELLING_IN_CHANNEL:
				return "booking_count_channel_";
			case DISTANCE:
				return "distance";
			case PRICE:
				return "_score";
			default:
				return "_score";
		}
	}
}
