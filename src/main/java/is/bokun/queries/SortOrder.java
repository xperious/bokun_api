package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The sort order of search results. Either ascending or descending.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SortOrder {

	ASC,
	DESC;

}
