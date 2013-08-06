package is.bokun.dtos;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagGroupDto extends ItemDto {

	public List<ItemDto> tags = new ArrayList<>();
	public String facetName;
    public List<String> flags = new ArrayList<>();
	
	public TagGroupDto() {}

	public TagGroupDto(Long id, String title, String facetName, List<String> flags) {
		super(id, title, flags);
		this.facetName = facetName;
        this.flags = flags;
	}

	public List<ItemDto> getTags() {
		return tags;
	}
	public void setTags(List<ItemDto> tags) {
		this.tags = tags;
	}
	
	public String getFacetName() {
		return facetName;
	}
	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}
}
