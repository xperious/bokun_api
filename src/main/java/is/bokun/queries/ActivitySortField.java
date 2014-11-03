package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The available sort fields for Activity results.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ActivitySortField {

	BEST_SELLING_GLOBAL,
	BEST_SELLING_IN_CHANNEL,
	ALPHABETIC,
	RANDOM;
	
	public String field() {
		switch (this) {
			case BEST_SELLING_GLOBAL:
				return "booking_count";
			case BEST_SELLING_IN_CHANNEL:
				return "booking_count_channel_";
			default:
				return "_score";
		}
	}

}
