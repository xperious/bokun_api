package is.bokun.dtos.carrental;

import is.bokun.dtos.LocationDto;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "carRentalLocation")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarRentalLocationDto {

	public Long id;	
	public String title;
	
	public boolean allDay;
	public int openingHour;
	public int closingHour;

	public Double priceForPickup;
	public Double priceForDropoff;
	public Double priceForPickupAndDropoff;

	@XmlElementWrapper
	@XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();
	
	public LocationDto location = new LocationDto();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public int getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(int openingHour) {
		this.openingHour = openingHour;
	}

	public int getClosingHour() {
		return closingHour;
	}

	public void setClosingHour(int closingHour) {
		this.closingHour = closingHour;
	}

	public Double getPriceForPickup() {
		return priceForPickup;
	}

	public void setPriceForPickup(Double priceForPickup) {
		this.priceForPickup = priceForPickup;
	}

	public Double getPriceForDropoff() {
		return priceForDropoff;
	}

	public void setPriceForDropoff(Double priceForDropoff) {
		this.priceForDropoff = priceForDropoff;
	}

	public Double getPriceForPickupAndDropoff() {
		return priceForPickupAndDropoff;
	}

	public void setPriceForPickupAndDropoff(Double priceForPickupAndDropoff) {
		this.priceForPickupAndDropoff = priceForPickupAndDropoff;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}
}
