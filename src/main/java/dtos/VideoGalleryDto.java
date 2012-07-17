package dtos;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;

public class VideoGalleryDto {

	@CollectionProperty(itemTranslation = VideoDto.class)
	public List<VideoDto> videos;
}
