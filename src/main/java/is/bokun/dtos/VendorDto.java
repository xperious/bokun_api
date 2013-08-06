package is.bokun.dtos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorDto {

	public Long id;
	
	public String title;
	
	public String currencyCode;

    public VendorDto() {}

    public VendorDto(Long id, String title, String currencyCode) {
        this.id = id;
        this.title = title;
        this.currencyCode = currencyCode;
    }

}
