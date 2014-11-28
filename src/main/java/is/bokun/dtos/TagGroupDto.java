package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagGroupDto extends ItemDto {

	public List<TagDto> tags = new ArrayList<>();
    public boolean group;
    public String facetName;
	public Long ownerId;
    public List<String> flags = new ArrayList<>();

    public TagGroupDto(){}

    public TagGroupDto(TagGroupDto other){
        this.id = other.id;
        this.title = other.title;
        this.group = other.group;
        this.facetName = other.facetName;
        this.ownerId = other.ownerId;
        this.flags.addAll(other.flags);
    }

	public TagGroupDto(boolean group, Long id, String title, String facetName, Long ownerId, List<String> flags) {
		super(id, title, flags);
        this.group = group;
        this.facetName = facetName;
		this.ownerId = ownerId;
        this.flags = flags;
	}

	public List<TagDto> getTags() {
		return tags;
	}
	public void setTags(List<TagDto> tags) {
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
