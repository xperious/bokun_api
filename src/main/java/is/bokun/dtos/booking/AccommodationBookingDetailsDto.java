package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.accommodation.AccommodationDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "accommodationBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccommodationBookingDetailsDto extends ProductBookingDetailsDto {

	public Date startDate, endDate;
    public AccommodationDto accommodation;

	public List<RoomBookingDetailsDto> rooms = new ArrayList<>();

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<RoomBookingDetailsDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomBookingDetailsDto> rooms) {
        this.rooms = rooms;
    }

    public AccommodationDto getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(AccommodationDto accommodation) {
        this.accommodation = accommodation;
    }
}
