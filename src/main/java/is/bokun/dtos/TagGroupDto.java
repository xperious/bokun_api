package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagGroupDto extends ItemDto {

	public List<ItemDto> tags = new ArrayList<>();
    public boolean group;
    public String facetName;
	public Long ownerId;
    public List<String> flags = new ArrayList<>();

    public TagGroupDto(){}

	public TagGroupDto(boolean group, Long id, String title, String facetName, Long ownerId, List<String> flags) {
		super(id, title, flags);
        this.group = group;
        this.facetName = facetName;
		this.ownerId = ownerId;
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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

    public boolean getGroup() {
        return group;
    }
}
