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
public abstract class ProductDto {

    public Long id;
    public String externalId;
    public Long productGroupId;
    public String productCategory;

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
}
