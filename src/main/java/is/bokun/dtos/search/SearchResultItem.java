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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	public ItemDto getVendor() {
		return vendor;
	}

	public void setVendor(ItemDto vendor) {
		this.vendor = vendor;
	}

	public boolean isBox() {
		return box;
	}

	public void setBox(boolean box) {
		this.box = box;
	}

	public Long getBoxedProductId() {
		return boxedProductId;
	}

	public void setBoxedProductId(Long boxedProductId) {
		this.boxedProductId = boxedProductId;
	}

	public Long getBoxedSupplierId() {
		return boxedSupplierId;
	}

	public void setBoxedSupplierId(Long boxedSupplierId) {
		this.boxedSupplierId = boxedSupplierId;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public void setBaseLanguage(String baseLanguage) {
		this.baseLanguage = baseLanguage;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getPaymentCurrencies() {
		return paymentCurrencies;
	}

	public void setPaymentCurrencies(List<String> paymentCurrencies) {
		this.paymentCurrencies = paymentCurrencies;
	}

	public List<CustomFieldDto> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(List<CustomFieldDto> customFields) {
		this.customFields = customFields;
	}

	public List<PlaceDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceDto> places) {
		this.places = places;
	}

	public List<VideoDto> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoDto> videos) {
		this.videos = videos;
	}

	public Map<String, Object> getFields() {
		return fields;
	}

	public void setFields(Map<String, Object> fields) {
		this.fields = fields;
	}
}
