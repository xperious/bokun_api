package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "activityPricingCategoryBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityPricingCategoryBookingDto {

	public Long pricingCategoryId;
	public int quantity;
	public Double bookedPrice;
	public String bookedTitle;
	
	public Double bookedPickupPrice;
	public Double bookedDropoffPrice;
	
	@XmlElementWrapper
	@XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();
	
	public ActivityPricingCategoryBookingDto() {}
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity) {
		this.pricingCategoryId = pricingCategoryId;
		this.quantity = quantity;		
	}
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, Double bookedPrice, String bookedTitle, Double bookedPickupPrice, Double bookedDropoffPrice) {
		this(pricingCategoryId, quantity);
		this.bookedPrice = bookedPrice;
		this.bookedTitle = bookedTitle;
		this.bookedPickupPrice = bookedPickupPrice;
		this.bookedDropoffPrice = bookedDropoffPrice;
	}
}
