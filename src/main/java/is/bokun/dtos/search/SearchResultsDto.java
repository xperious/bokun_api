package is.bokun.dtos.search;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultsDto extends AbstractSearchResultsDto {
	
	public List<SearchResultItem> items = new ArrayList<>();
	
}
