package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.PhotoDto;
import is.bokun.dtos.VendorDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfoDto extends BookingItemInfoDto {

	public String slug;
	public PhotoDto keyPhoto;
    public VendorDto vendor;
	
	public ProductInfoDto() {
		super();
	}
	
	public ProductInfoDto(Long id, String title, String slug, VendorDto vendor) {
		super(id, title);
		this.slug = slug;
        this.vendor = vendor;
	}
	
}
