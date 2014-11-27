package is.bokun.dtos.search;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.dtos.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultItem implements SearchResult, WithPhotos {

	public String id, externalId;
    public Long productGroupId;
	public String title;
	public String summary;
	public String slug;
	public Double price;
	public LocationDto location;
	public ItemDto vendor;
    public boolean box;
    public Long boxedProductId;
    public Long boxedSupplierId;

    public List<String> keywords = new ArrayList<>();
    public List<String> flags = new ArrayList<>();
    
    public String baseLanguage;
    public List<String> languages = new ArrayList<>();

    public List<String> paymentCurrencies = new ArrayList<>();
    
    public List<CustomFieldDto> customFields = new ArrayList<>();
	
	public List<PlaceDto> places = new ArrayList<>();
	
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	
	public List<VideoDto> videos = new ArrayList<>();
	
	public Map<String,Object> fields = new HashMap<>();

    @JsonIgnore
	public Long getLongId() {
		return Long.parseLong(id);
	}
	
	public String getString(String name) {
		return fields.containsKey(name) ? fields.get(name).toString() : "";
	}
	
	public int getInt(String name) {
		return fields.containsKey(name) ? Integer.parseInt(getString(name)) : 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBaseLanguage() {
		return baseLanguage;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	@Override
	public void addPhoto(PhotoDto p) {
		photos.add(p);
	}
	@Override
	public List<PhotoDto> getPhotos() {
		return photos;
	}
	@Override
	public void setPhotos(List<PhotoDto> photos) {
		this.photos = photos;
	}
	@Override
	public void setKeyPhoto(PhotoDto p) {
		keyPhoto = p;
	}
	@Override
	public PhotoDto getKeyPhoto() {
		return keyPhoto;
	}
}
