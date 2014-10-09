package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "AvailableSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailableScheduleDto {

    public RouteScheduleDto schedule;
    public List<AvailableSeatsDto> availableSeats = new ArrayList<>();
    public TransportPricesDto prices;

    public AvailableScheduleDto() {}

    public AvailableScheduleDto(RouteScheduleDto schedule) {
        this.schedule = schedule;
    }

    public RouteScheduleDto getSchedule() {
        return schedule;
    }

    public void setSchedule(RouteScheduleDto schedule) {
        this.schedule = schedule;
    }

    public List<AvailableSeatsDto> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<AvailableSeatsDto> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public TransportPricesDto getPrices() {
        return prices;
    }

    public void setPrices(TransportPricesDto prices) {
        this.prices = prices;
    }
}
