package is.bokun.dtos.booking;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.PhotoDto;
import is.bokun.dtos.VendorDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "productInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInfoDto extends BookingItemInfoDto {

	public String slug;
	public PhotoDto keyPhoto;
    public VendorDto vendor;
    public String externalId;
	
	public ProductInfoDto() {
		super();
	}
	
	public ProductInfoDto(Long id, String title, String slug, VendorDto vendor) {
		super(id, title);
		this.slug = slug;
        this.vendor = vendor;
	}
	
	public ProductInfoDto(Long id, String title, String slug, VendorDto vendor, String externalId) {
		this(id, title, slug, vendor);
		this.externalId = externalId;
	}
}
