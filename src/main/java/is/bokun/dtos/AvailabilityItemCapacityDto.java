package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "availabilityItemCapacity")
@XmlType(name = "AvailabilityItemCapacity")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityItemCapacityDto {

    public Long id;
    public String availabilityItemId;
    public CapacityTypeEnum capacityType;
    public int capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailabilityItemId() {
        return availabilityItemId;
    }

    public void setAvailabilityItemId(String availabilityItemId) {
        this.availabilityItemId = availabilityItemId;
    }

    public CapacityTypeEnum getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(CapacityTypeEnum capacityType) {
        this.capacityType = capacityType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
