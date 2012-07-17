package dtos;

import java.util.Date;
import java.util.Set;

import com.codiform.moo.annotation.Property;

public abstract class ProductDto {

    public Long id;
    public  String externalId;

    public String title;
    public String description;
    public Date lastPublished;

    public Set<Long> tags;
    
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
