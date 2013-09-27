package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "activityPricingCategoryBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityPricingCategoryBookingDto {

	public Long pricingCategoryId;
	public int quantity;
	public Double bookedPrice;
	public String bookedTitle;
	
	@XmlElementWrapper
	@XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();
	
	public ActivityPricingCategoryBookingDto() {}
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity) {
		this.pricingCategoryId = pricingCategoryId;
		this.quantity = quantity;		
	}
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, Double bookedPrice, String bookedTitle) {
		this(pricingCategoryId, quantity);
		this.bookedPrice = bookedPrice;
		this.bookedTitle = bookedTitle;
	}
}
