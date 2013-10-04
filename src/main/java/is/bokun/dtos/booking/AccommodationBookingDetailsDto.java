package is.bokun.dtos.booking;

import java.util.*;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "accommodationBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccommodationBookingDetailsDto extends ProductBookingDetailsDto {

	public Date startDate, endDate;
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
}
