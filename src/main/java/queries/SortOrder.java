package queries;

/**
 * @author Olafur Gauti Gudmundsson
 */
public enum SortOrder {

	ASC,
	DESC;

	/*
	public org.elasticsearch.search.sort.SortOrder toElastic() {
		switch(this) {
			case ASC:
				return org.elasticsearch.search.sort.SortOrder.ASC;
			case DESC:
				return org.elasticsearch.search.sort.SortOrder.DESC;
			default:
				return org.elasticsearch.search.sort.SortOrder.ASC;
		}
	}*/
}
