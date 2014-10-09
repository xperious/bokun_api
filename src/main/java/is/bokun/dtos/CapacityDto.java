package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ogg on 17.8.2014.
 */
public class CapacityDto {

    public CapacityTypeEnum capacityType;
    public int capacity;

    public CapacityDto() {}

    public CapacityDto(CapacityTypeEnum capacityType, int capacity) {
        this.capacityType = capacityType;
        this.capacity = capacity;
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

    @JsonIgnore
    public boolean hasCapacityFor(int passengers) {
        return capacityType == CapacityTypeEnum.UNLIMITED || capacity >= passengers;
    }
}
