package is.bokun.dtos;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

public class PhotoGalleryDto {

	public PhotoDto keyPhoto;
	
	public List<PhotoDto> photos;
}
