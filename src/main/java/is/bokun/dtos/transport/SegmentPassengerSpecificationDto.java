package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 18.9.2014.
 */
public class SegmentPassengerSpecificationDto {

    public Long fareClassId;
    public List<PricingCategoryPassengerSpecificationDto> passengerSpecifications = new ArrayList<>();

    public SegmentPassengerSpecificationDto() {}

    public SegmentPassengerSpecificationDto(Long fareClassId, PricingCategoryPassengerSpecificationDto pspec) {
        this.fareClassId = fareClassId;
        this.passengerSpecifications.add(pspec);
    }

    public Long getFareClassId() {
        return fareClassId;
    }

    public void setFareClassId(Long fareClassId) {
        this.fareClassId = fareClassId;
    }

    @JsonIgnore
    public boolean hasFareClass() {
        return fareClassId != null && fareClassId > 0;
    }

    @JsonIgnore
    public int getTotalPassengers() {
        int passengers = 0;
        for (PricingCategoryPassengerSpecificationDto pspec : passengerSpecifications) {
            passengers += pspec.passengers;
        }
        return passengers;
    }

    public List<PricingCategoryPassengerSpecificationDto> getPassengerSpecifications() {
        return passengerSpecifications;
    }

    public void setPassengerSpecifications(List<PricingCategoryPassengerSpecificationDto> passengerSpecifications) {
        this.passengerSpecifications = passengerSpecifications;
    }
}
