package is.bokun.dtos.carrental;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import is.bokun.dtos.LocationDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "CarRentalLocation")
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
	
	public List<String> flags = new ArrayList<>();
	
	public LocationDto location = new LocationDto();

}
