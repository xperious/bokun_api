package dtos;

import java.util.ArrayList;
import java.util.List;

public class TagGroupDto extends ItemDto {

	public List<ItemDto> tags = new ArrayList<>();
	public String facetName;
    public List<String> flags = new ArrayList<>();
	
	public TagGroupDto() {}

	public TagGroupDto(Long id, String title, String facetName) {
		super(id, title);
		this.facetName = facetName;
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

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
