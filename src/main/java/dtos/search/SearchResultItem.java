package dtos.search;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import dtos.*;

public class SearchResultItem {

	public String id;
	public String title;
	public String summary;
	public Integer price;
	public Double distance;
	public LocationDto location;
	
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<PhotoDto>();
	
	public List<VideoDto> videos = new ArrayList<VideoDto>();
	
	public Map<String,Object> fields = new HashMap<String,Object>();
	
	@JsonIgnore
	public Long getLongId() {
		return Long.parseLong(id);
	}
	
	public String getString(String name) {
		return fields.get(name).toString();
	}
	
	public int getInt(String name) {
		return Integer.parseInt(getString(name));
	}
}
