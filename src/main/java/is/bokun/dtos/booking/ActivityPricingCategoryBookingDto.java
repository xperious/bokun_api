package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
	
	public ActivityPricingCategoryBookingDto(Long pricingCategoryId, int quantity, String bookedTitle) {
		this(pricingCategoryId, quantity);
		this.bookedTitle = bookedTitle;
	}

	public Long getPricingCategoryId() {
		return pricingCategoryId;
	}

	public void setPricingCategoryId(Long pricingCategoryId) {
		this.pricingCategoryId = pricingCategoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getBookedPrice() {
		return bookedPrice;
	}

	public void setBookedPrice(Double bookedPrice) {
		this.bookedPrice = bookedPrice;
	}

	public String getBookedTitle() {
		return bookedTitle;
	}

	public void setBookedTitle(String bookedTitle) {
		this.bookedTitle = bookedTitle;
	}

	public Double getBookedPickupPrice() {
		return bookedPickupPrice;
	}

	public void setBookedPickupPrice(Double bookedPickupPrice) {
		this.bookedPickupPrice = bookedPickupPrice;
	}

	public Double getBookedDropoffPrice() {
		return bookedDropoffPrice;
	}

	public void setBookedDropoffPrice(Double bookedDropoffPrice) {
		this.bookedDropoffPrice = bookedDropoffPrice;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
}
