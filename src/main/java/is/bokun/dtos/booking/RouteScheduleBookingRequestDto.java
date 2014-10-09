package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ogg on 23/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteScheduleBookingRequestDto {

    public Long routeLegId;
    public Long scheduleId;
    public Long pickupPlaceId, dropoffPlaceId;

    public Long getRouteLegId() {
        return routeLegId;
    }

    public void setRouteLegId(Long routeLegId) {
        this.routeLegId = routeLegId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getPickupPlaceId() {
        return pickupPlaceId;
    }

    public void setPickupPlaceId(Long pickupPlaceId) {
        this.pickupPlaceId = pickupPlaceId;
    }

    public Long getDropoffPlaceId() {
        return dropoffPlaceId;
    }

    public void setDropoffPlaceId(Long dropoffPlaceId) {
        this.dropoffPlaceId = dropoffPlaceId;
    }
}
