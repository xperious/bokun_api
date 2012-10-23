package dtos;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import utils.StringUtils;

public abstract class ProductDto {

    public Long id;
    public  String externalId;

    public String title;
    public String description;
    public String slug;
    
    public List<TagGroupDto> tags = new ArrayList<TagGroupDto>();
    
    public PhotoDto keyPhoto;
    public List<PhotoDto> photos = new ArrayList<PhotoDto>();
    public List<VideoDto> videos = new ArrayList<VideoDto>();
    
    public VendorDto vendor;
    
    public WidgetSettingsDto widgets;
    
    public ProductDto() {}
    
    @JsonIgnore
    public TagGroupDto findTagGroup(String facetName) {
    	for (TagGroupDto group : tags) {
    		if ( !StringUtils.isNullOrEmpty(group.facetName) && group.facetName.equals(facetName) ) {
    			return group;
    		}
    	}
    	return null;
    }
    
    @JsonIgnore
    public List<TagGroupDto> filteredTagGroups(String... excluded) {
    	List<TagGroupDto> filtered = new ArrayList<TagGroupDto>();
    	for (TagGroupDto group : tags) {
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
