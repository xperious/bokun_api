package dtos.booking;

import java.util.Date;

public abstract class ProductBookingDto {

	public Long id;
	
	public Date creationDate;
	public Date lastModifedDate;
    
    public String userUuid;
    
    public String bookingStatus;
    
    public int totalPrice;
}
