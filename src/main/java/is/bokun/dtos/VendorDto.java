package is.bokun.dtos;

import com.codiform.moo.annotation.Property;

public class VendorDto {

	public Long id;
	
	@Property(translation = "getName()")
	public String title;
	
	public String currencyCode;

    public VendorDto() {}

    public VendorDto(Long id, String title, String currencyCode) {
        this.id = id;
        this.title = title;
        this.currencyCode = currencyCode;
    }

}
