package dtos.search;

import java.util.ArrayList;
import java.util.List;

import dtos.LocationDto;
import dtos.PhotoDto;

public class SearchResultItem {

	public String id;
	public String title;
	public String summary;
	public Integer price;
	public Double distance;
	public LocationDto location;
	
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<PhotoDto>();
}
