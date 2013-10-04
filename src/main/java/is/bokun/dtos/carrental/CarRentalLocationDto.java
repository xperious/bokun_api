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
	
	public int priceForPickup;
	public int priceForDropoff;
	public int priceForPickupAndDropoff;
	
	@XmlElementWrapper
	@XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();
	
	public LocationDto location = new LocationDto();

}
