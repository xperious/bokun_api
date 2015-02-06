package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.utils.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "activityPricingCategoryBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityPricingCategoryBookingDto {

	public Long pricingCategoryId;
	public PricingCategoryDto pricingCategory;
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
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, String bookedTitle) {
		this(pricingCategoryId, quantity);
		this.bookedTitle = bookedTitle;
	}

	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, PricingCategoryDto pricingCategory) {
		this(pricingCategoryId, quantity, !StringUtils.isNullOrEmpty(pricingCategory.title) ? pricingCategory.title : "");
		this.pricingCategory = pricingCategory;
	}
}
