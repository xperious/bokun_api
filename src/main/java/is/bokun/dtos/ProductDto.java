package is.bokun.dtos;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProductDto {

    public Long id;
    public String externalId;
    public Long productGroupId;
    public String productCategory;

    public String title;
    public String description;
    public List<String> keywords = new ArrayList<>();
    public List<String> flags = new ArrayList<>();
    public String slug;
    
    public String baseLanguage;
    public List<String> languages = new ArrayList<>();
    
    public List<CustomFieldDto> customFields = new ArrayList<>();
    
    public List<TagGroupDto> tagGroups = new ArrayList<>();
    
    public PhotoDto keyPhoto;
    public List<PhotoDto> photos = new ArrayList<>();
    public List<VideoDto> videos = new ArrayList<>();
    
    public VendorDto vendor;

    public ProductDto() {}
    
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
