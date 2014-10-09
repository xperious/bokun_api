package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.CapacityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "AvailableSeats")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailableSeatsDto {

    public String fareClassId;
    public CapacityDto capacity;

    public AvailableSeatsDto() {}

    public AvailableSeatsDto(String fareClassId, CapacityDto capacity) {
        this.fareClassId = fareClassId;
        this.capacity = capacity;
    }

    public String getFareClassId() {
        return fareClassId;
    }

    public void setFareClassId(String fareClassId) {
        this.fareClassId = fareClassId;
    }

    public CapacityDto getCapacity() {
        return capacity;
    }

    public void setCapacity(CapacityDto capacity) {
        this.capacity = capacity;
    }
}
