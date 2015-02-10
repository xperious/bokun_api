package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

import javax.xml.bind.annotation.*;

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

    @XmlElementWrapper
    @XmlElement(name="keyword")
    public List<String> keywords = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    public String slug;
    
    public String baseLanguage;

    @XmlElementWrapper
    @XmlElement(name="language")
    public List<String> languages = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="currency")
    public List<String> paymentCurrencies = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="customField")
    public List<CustomFieldDto> customFields = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="tagGroup")
    public List<TagGroupDto> tagGroups = new ArrayList<>();
    
    public PhotoDto keyPhoto;

    @XmlElementWrapper
    @XmlElement(name="photo")
    public List<PhotoDto> photos = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="video")
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
}
