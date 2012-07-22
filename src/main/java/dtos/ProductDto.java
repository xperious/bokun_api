package dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;

public abstract class ProductDto {

    public Long id;
    public  String externalId;

    public String title;
    public String description;
    public Date lastPublished;

    public Set<Long> tags;
    
    @CollectionProperty(optionality=Optionality.OPTIONAL)
    public Set<TagGroupDto> tagGroups = new HashSet<TagGroupDto>();
    
    @Property(translate = true)
    public VendorDto vendor;
    
    @Property(translate = true)
    public PhotoGalleryDto photoGallery;
    
    @Property(translate = true)
    public VideoGalleryDto videoGallery;
    
    @Property(translate = true, translation = "pageSettings")
    public WidgetSettingsDto widgets;
    
    public ProductDto() {}
}
