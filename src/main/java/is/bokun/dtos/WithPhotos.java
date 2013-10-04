package is.bokun.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface WithPhotos {

	public void addPhoto(PhotoDto p);
	public List<PhotoDto> getPhotos();
	public void setPhotos(List<PhotoDto> photos);
	public void setKeyPhoto(PhotoDto p);
	public PhotoDto getKeyPhoto();
}
