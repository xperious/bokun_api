package dtos.search;

import java.util.List;

public class SearchResultsDto<T extends SearchResultItem> {

	public Long tookInMillis;
	public Long totalHits;
	
	public List<T> items;
}
