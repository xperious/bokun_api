package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public enum AccommodationSortField {

	BEST_SELLING,
	PRICE,
	DISTANCE;
	
	public String field() {
		switch (this) {
			case BEST_SELLING:
				return "bookingCount";
			case DISTANCE:
				return "distance";
			case PRICE:
				return "_score";
			default:
				return "_score";
		}
	}
}
