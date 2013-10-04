package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "vendor")
@XmlAccessorType(XmlAccessType.FIELD)
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
