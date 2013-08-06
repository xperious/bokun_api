package is.bokun.dtos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoGalleryDto {

	public PhotoDto keyPhoto;
	
	public List<PhotoDto> photos;
}
