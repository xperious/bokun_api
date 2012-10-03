package dtos;

import java.util.*;

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
}
