package is.bokun.dtos.search;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TermFilter {

	public String facetName;
	public String value;
	public String title;
	public String groupTitle;
	
	public TermFilter() {}
	
	public TermFilter(String facetName, String value, String title, String groupTitle) {
		this.facetName = facetName;
		this.value = value;
		this.title = title;
		this.groupTitle = groupTitle;
	}
}
