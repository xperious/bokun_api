package dtos;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

public class PhotoGalleryDto {

	@Property(translate = true)
	public PhotoDto keyPhoto;
	
	@CollectionProperty(itemTranslation = PhotoDto.class, translation = "getPhotos()")
	public List<PhotoDto> photos;
}
