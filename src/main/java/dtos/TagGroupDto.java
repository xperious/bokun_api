package dtos;

import java.util.ArrayList;
import java.util.List;

public class TagGroupDto extends ItemDto {

	public List<ItemDto> tags = new ArrayList<ItemDto>();
	
	public TagGroupDto() {}
	public TagGroupDto(Long id, String title) {
		super(id, title);
	}

	public List<ItemDto> getTags() {
		return tags;
	}

	public void setTags(List<ItemDto> tags) {
		this.tags = tags;
	}
	
}
