package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ogg on 22/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportBookingRequestDto {

    public String departureDate, returnDate;

    public List<RoutePathSegmentBookingRequest> pathSegments = new ArrayList<>();


    public List<RoutePathSegmentBookingRequest> getPathSegments() {
        return pathSegments;
    }

    public void setPathSegments(List<RoutePathSegmentBookingRequest> pathSegments) {
        this.pathSegments = pathSegments;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @JsonIgnore
    public Set<Long> getRouteIds() {
        Set<Long> ids = new HashSet<>();
        for (RoutePathSegmentBookingRequest segment : pathSegments) {
            ids.add(segment.routeId);
        }
        return ids;
    }
}
