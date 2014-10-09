package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.accommodation.AccommodationAvailabilityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "accommodationAvailabilityBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccommodationAvailabilityBookingDto {

	public Long id;
	
	public AccommodationAvailabilityDto availability;
	
}
