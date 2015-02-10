package is.bokun.dtos.booking;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.VendorDto;

import java.util.Date;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public abstract class ProductBookingDto {

	public Long id;
    public String productConfirmationCode;
	
	public Date creationDate;
	public Date lastModifiedDate;
    
    public String customerUuid;
    
    public String bookingStatus;

    public int totalPrice;

    @JsonIgnore
    public abstract VendorDto getVendor();
    
    @JsonIgnore
    public abstract Date getSortDate(); 
    
    @JsonIgnore
    public abstract String getProductCategory();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductConfirmationCode() {
        return productConfirmationCode;
    }

    public void setProductConfirmationCode(String productConfirmationCode) {
        this.productConfirmationCode = productConfirmationCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
