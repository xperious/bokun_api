package queries;

public enum ActivitySortField {

	BEST_SELLING_GLOBAL,
	BEST_SELLING_IN_CHANNEL,
	PLACE_DISTANCE,
	PRICE,
	ALPHABETIC,
	RANDOM;
	
	public String field() {
		switch (this) {
			case BEST_SELLING_GLOBAL:
				return "booking_count";
			case BEST_SELLING_IN_CHANNEL:
				return "booking_count_channel_";
			case PRICE:
				return "_score";
			default:
				return "_score";
		}
	}

}
