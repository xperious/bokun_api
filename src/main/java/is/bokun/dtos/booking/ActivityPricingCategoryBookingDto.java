package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityPricingCategoryBookingDto {

	public Long pricingCategoryId;
	public int quantity;
	public Double bookedPrice;
	public String bookedTitle;
	
	public ActivityPricingCategoryBookingDto() {}
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, Double bookedPrice, String bookedTitle) {
		this.pricingCategoryId = pricingCategoryId;
		this.quantity = quantity;
		this.bookedPrice = bookedPrice;
		this.bookedTitle = bookedTitle;
	}
}
