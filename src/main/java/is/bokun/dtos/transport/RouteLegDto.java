package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.AbstractIdDto;
import is.bokun.dtos.DistanceUnitEnum;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteLeg")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteLegDto extends AbstractIdDto {

    public String externalId;

    public int distance;
    public DistanceUnitEnum distanceUnit;

    public RouteStationDto from;
    public RouteStationDto to;

    @XmlElementWrapper
    @XmlElement(name="schedule")
    public List<RouteScheduleDto> schedules = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    public RouteLegDto() {}

    public RouteLegDto(RouteStationDto from, RouteStationDto to) {
        this.from = from;
        this.to = to;
    }

    @JsonIgnore
    public RouteScheduleDto findScheduleById(Long sId) {
        for (RouteScheduleDto schedule : schedules) {
            if ( schedule.id.equals(sId) ) {
                return schedule;
            }
        }
        return null;
    }

    @JsonIgnore
    public Long getPickupPlaceId() {
        return from.pickupStation ? from.pickupPlaceId : null;
    }

    @JsonIgnore
    public Long getDropoffPlaceId() {
        return to.pickupStation ? to.pickupPlaceId : null;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public DistanceUnitEnum getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnitEnum distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public RouteStationDto getFrom() {
        return from;
    }

    public void setFrom(RouteStationDto from) {
        this.from = from;
    }

    public RouteStationDto getTo() {
        return to;
    }

    public void setTo(RouteStationDto to) {
        this.to = to;
    }

    public List<RouteScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<RouteScheduleDto> schedules) {
        this.schedules = schedules;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
