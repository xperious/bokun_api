package is.bokun.dtos.search;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultsDto extends AbstractSearchResultsDto {
	
	public List<SearchResultItem> items = new ArrayList<>();
	
}
