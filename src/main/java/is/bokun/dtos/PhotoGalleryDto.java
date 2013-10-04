package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoGalleryDto {

	public PhotoDto keyPhoto;
	
	public List<PhotoDto> photos;
}
