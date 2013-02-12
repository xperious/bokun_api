package dtos.search;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import dtos.*;

public class SearchResultItem {

	public String id;
	public String title;
	public String summary;
	public String slug;
	public Integer price;
	public LocationDto location;
	public ItemDto vendor;

    public List<String> keywords = new ArrayList<>();
	
	public List<PlaceDto> places = new ArrayList<>();
	
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	
	public List<VideoDto> videos = new ArrayList<>();
	
	public Map<String,Object> fields = new HashMap<>();
	
	@JsonIgnore
	public Long getLongId() {
		return Long.parseLong(id);
	}
	
	public String getString(String name) {
		return fields.containsKey(name) ? fields.get(name).toString() : "";
	}
	
	public int getInt(String name) {
		return fields.containsKey(name) ? Integer.parseInt(getString(name)) : 0;
	}
}
