package is.bokun.dtos.booking;

import is.bokun.dtos.VendorDto;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ProductBookingDto {

	public Long id;
	
	public Date creationDate;
	public Date lastModifedDate;
    
    public String customerUuid;
    
    public String bookingStatus;

    public int totalPrice;

    @JsonIgnore
    public abstract VendorDto getVendor();
    
    @JsonIgnore
    public abstract Date getSortDate(); 
    
    @JsonIgnore
    public abstract String getProductCategory();
}
