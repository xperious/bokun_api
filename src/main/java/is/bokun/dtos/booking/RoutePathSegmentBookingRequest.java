package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.transport.SegmentPassengerSpecificationDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 23/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoutePathSegmentBookingRequest {

    public Long routeId;
    public boolean returning; // specifies whether this segment is part of a return path
    public List<RouteScheduleBookingRequestDto> departureSchedules = new ArrayList<>();
    public List<RouteScheduleBookingRequestDto> returnSchedules = new ArrayList<>();

    public SegmentPassengerSpecificationDto passengerSpecification;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public List<RouteScheduleBookingRequestDto> getDepartureSchedules() {
        return departureSchedules;
    }

    public void setDepartureSchedules(List<RouteScheduleBookingRequestDto> departureSchedules) {
        this.departureSchedules = departureSchedules;
    }

    public List<RouteScheduleBookingRequestDto> getReturnSchedules() {
        return returnSchedules;
    }

    public void setReturnSchedules(List<RouteScheduleBookingRequestDto> returnSchedules) {
        this.returnSchedules = returnSchedules;
    }

    public SegmentPassengerSpecificationDto getPassengerSpecification() {
        return passengerSpecification;
    }

    public void setPassengerSpecification(SegmentPassengerSpecificationDto passengerSpecification) {
        this.passengerSpecification = passengerSpecification;
    }
}
