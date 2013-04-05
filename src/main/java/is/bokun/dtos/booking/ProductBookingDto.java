package is.bokun.dtos.booking;

import java.util.Date;

import is.bokun.dtos.VendorDto;
import org.codehaus.jackson.annotate.JsonIgnore;

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
}
