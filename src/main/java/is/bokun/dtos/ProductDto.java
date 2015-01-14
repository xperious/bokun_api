package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class ProductDto extends AbstractIdDto {

    public String externalId;
    public Long productGroupId;
    public String productCategory;

    public boolean box;
    public String lastPublished;

    public String title;
    public String description;
    public List<String> keywords = new ArrayList<>();
    public List<String> flags = new ArrayList<>();
    public String slug;
    
    public String baseLanguage;
    public List<String> languages = new ArrayList<>();

    public List<String> paymentCurrencies = new ArrayList<>();
    
    public List<CustomFieldDto> customFields = new ArrayList<>();
    
    public List<TagGroupDto> tagGroups = new ArrayList<>();
    
    public PhotoDto keyPhoto;
    public List<PhotoDto> photos = new ArrayList<>();
    public List<VideoDto> videos = new ArrayList<>();
    
    public VendorDto vendor;
    public VendorDto boxedVendor;

    public ProductDto() {}

    @JsonIgnore
    public List<CustomFieldDto> findCustomFieldsByFlag(String flag) {
        List<CustomFieldDto> list = new ArrayList<>();
        if (customFields != null) {
            for (CustomFieldDto dto : customFields) {
                if ( dto.flags != null && StringUtils.containsIgnoreCase(dto.flags, flag) ) {
                    list.add(dto);
                }
            }
        }
        return list;
    }

    @JsonIgnore
    public TagGroupDto findTagGroup(String facetName) {
    	for (TagGroupDto group : tagGroups) {
    		if ( !StringUtils.isNullOrEmpty(group.facetName) && group.facetName.equals(facetName) ) {
    			return group;
    		}
    	}
    	return null;
    }
    
    @JsonIgnore
    public List<TagGroupDto> filteredTagGroups(String... excluded) {
    	List<TagGroupDto> filtered = new ArrayList<TagGroupDto>();
    	for (TagGroupDto group : tagGroups) {
    		boolean found = false;
    		for (String excludedName : excluded) {
    			if ( !StringUtils.isNullOrEmpty(group.facetName) && group.facetName.equals(excludedName) ) {
    				found = true;
    			}
    		}
    		if ( !found ) {
    			filtered.add(group);
    		}
    	}
    	return filtered;
    }

    public VendorDto getActualVendor() {
        return box ? boxedVendor : vendor;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public String getLastPublished() {
        return lastPublished;
    }

    public void setLastPublished(String lastPublished) {
        this.lastPublished = lastPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBaseLanguage() {
        return baseLanguage;
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

    public List<TagGroupDto> getTagGroups() {
        return tagGroups;
    }

    public void setTagGroups(List<TagGroupDto> tagGroups) {
        this.tagGroups = tagGroups;
    }

    public PhotoDto getKeyPhoto() {
        return keyPhoto;
    }

    public void setKeyPhoto(PhotoDto keyPhoto) {
        this.keyPhoto = keyPhoto;
    }

    public List<PhotoDto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDto> photos) {
        this.photos = photos;
    }

    public List<VideoDto> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDto> videos) {
        this.videos = videos;
    }

    public VendorDto getVendor() {
        return vendor;
    }

    public void setVendor(VendorDto vendor) {
        this.vendor = vendor;
    }

    public VendorDto getBoxedVendor() {
        return boxedVendor;
    }

    public void setBoxedVendor(VendorDto boxedVendor) {
        this.boxedVendor = boxedVendor;
    }
}
