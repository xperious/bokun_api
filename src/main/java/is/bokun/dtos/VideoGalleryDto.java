package is.bokun.dtos;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;

public class VideoGalleryDto {

	@CollectionProperty(itemTranslation = VideoDto.class, translation = "getVideos()")
	public List<VideoDto> videos;
}
