package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.AbstractIdDto;
import org.joda.time.LocalTime;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteScheduleDto extends AbstractIdDto {

    public int departureHour;
    public int departureMinute;

    public int arrivalHour;
    public int arrivalMinute;

    public Boolean peak;

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    public RouteScheduleDto() {}

    public RouteScheduleDto(LocalTime departure, LocalTime arrival) {
        setDepartureTime(departure);
        setArrivalTime(arrival);
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(int departureHour) {
        this.departureHour = departureHour;
    }

    public int getDepartureMinute() {
        return departureMinute;
    }

    public void setDepartureMinute(int departureMinute) {
        this.departureMinute = departureMinute;
    }

    public int getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(int arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public int getArrivalMinute() {
        return arrivalMinute;
    }

    public void setArrivalMinute(int arrivalMinute) {
        this.arrivalMinute = arrivalMinute;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public Boolean getPeak() {
        return peak;
    }

    public void setPeak(Boolean peak) {
        this.peak = peak;
    }

    public void setDepartureTime(LocalTime time) {
        this.departureHour = time.getHourOfDay();
        this.departureMinute = time.getMinuteOfHour();
    }

    @JsonIgnore
    public LocalTime getDepartureTime() {
        return new LocalTime(departureHour, departureMinute);
    }

    public void setArrivalTime(LocalTime time) {
        this.arrivalHour = time.getHourOfDay();
        this.arrivalMinute = time.getMinuteOfHour();
    }

    @JsonIgnore
    public LocalTime getArrivalTime() {
        return new LocalTime(arrivalHour, arrivalMinute);
    }
}
