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
	
	@JsonIgnore
	public Long getLongId() {
		return Long.parseLong(id);
	}
}
