package is.bokun.dtos.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TermFilter {

	public String facetName;
	public String value;
	public String title;
	public String groupTitle;
	public boolean excluded;
	
	public TermFilter() {}
	
	public TermFilter(String facetName, String value, String title, String groupTitle, boolean excluded) {
		this.facetName = facetName;
		this.value = value;
		this.title = title;
		this.groupTitle = groupTitle;
		this.excluded = excluded;
	}
	
	public TermFilter(String facetName, String value, String title, String groupTitle) {
		this(facetName, value, title, groupTitle, false);
	}
}
