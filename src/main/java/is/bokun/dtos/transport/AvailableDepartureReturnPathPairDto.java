package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import is.bokun.dtos.CapacityDto;
import is.bokun.dtos.CapacityTypeEnum;
import is.bokun.queries.TransportQuery;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by ogg on 27.8.2014.
 */
public class AvailableDepartureReturnPathPairDto {

    public AvailablePathDto departurePath;
    public AvailablePathDto returnPath;

    public RouteAvailabilityReportDto.RouteResultsType resultsType;

    /**
     * get route segments
     * a segment is a list of adjacent legs of the same route in the path
     * a segment has  a list of passenger price specifications
     * each segment can have a return segment attached
     * a segment results in a RouteBooking
     */
    public List<AvailablePathSegmentDto> getRouteSegments(TransportQuery query) {
        List<AvailablePathSegmentDto> departureSegments = new ArrayList<>();
        List<AvailablePathSegmentDto> returnSegments = new ArrayList<>();

        AvailablePathSegmentDto currentSegment = null;
        for (AvailableLegDto leg : departurePath.legs) {
            if (currentSegment == null || !leg.route.id.equals(currentSegment.route.id)) {
                currentSegment = new AvailablePathSegmentDto(leg.route, false, createPassengerSpecification(leg.route, query));
                departureSegments.add(currentSegment);
            }
            currentSegment.departurePath.add(leg);
        }

        // return path
        if ( returnPath != null ) {
            AvailablePathSegmentDto currentReturnSegment = null;
            for (AvailableLegDto leg : returnPath.legs) {
                if (currentReturnSegment == null) {
                    currentReturnSegment = new AvailablePathSegmentDto(leg.route, true, createPassengerSpecification(leg.route, query));
                    currentReturnSegment.returning = true;
                } else if ( !leg.route.id.equals(currentReturnSegment.route.id) ) {
                    if ( leg.route.returnPricing ) {
                        // check if this return segment has a corresponding departure segment
                        for (AvailablePathSegmentDto departureSegment : departureSegments) {
                            if ( Lists.reverse(departureSegment.getDepartureStationIds()).equals(currentReturnSegment.getDepartureStationIds()) ) {
                                departureSegment.returnPath = currentReturnSegment.departurePath;
                                break;
                            }
                        }
                    } else {
                        returnSegments.add(currentReturnSegment);
                    }
                    currentReturnSegment = new AvailablePathSegmentDto(leg.route, true, createPassengerSpecification(leg.route, query));
                    currentReturnSegment.returning = true;
                }
                currentReturnSegment.departurePath.add(leg);
            }
            if ( currentReturnSegment != null ) {
                if (currentReturnSegment.route.returnPricing) {
                    // check if this return segment has a corresponding departure segment
                    boolean foundMatchingSegment = false;
                    for (AvailablePathSegmentDto departureSegment : departureSegments) {
                        if (Lists.reverse(departureSegment.getDepartureStationIds()).equals(currentReturnSegment.getDepartureStationIds())) {
                            departureSegment.returnPath = currentReturnSegment.departurePath;
                            foundMatchingSegment = true;
                            break;
                        }
                    }
                    if ( !foundMatchingSegment ) {
                        returnSegments.add(currentReturnSegment);
                    }
                } else {
                    returnSegments.add(currentReturnSegment);
                }
            }
        }

        List<AvailablePathSegmentDto> segments = Lists.newArrayList(departureSegments);
        segments.addAll(returnSegments);
        return segments;
    }

    private SegmentPassengerSpecificationDto createPassengerSpecification(RouteDto route, TransportQuery query) {
        Long fareClassId = query.hasFareClass() && route.findFareClassById(query.fareClassId) != null ? query.fareClassId : null;
        if ( !query.hasPricingCategories() ) {
            return new SegmentPassengerSpecificationDto(fareClassId, new PricingCategoryPassengerSpecificationDto(route.findDefaultPricingCategory().id, Math.max(1, query.passengers)));
        } else {
            SegmentPassengerSpecificationDto segmentSpec = new SegmentPassengerSpecificationDto();
            segmentSpec.fareClassId = fareClassId;
            for (PricingCategoryPassengerSpecificationDto pspec : query.pricingCategories) {
                if ( route.hasPricingCategory(pspec.categoryId) ) {
                    if ( pspec.passengers > 0 ) {
                        segmentSpec.passengerSpecifications.add(new PricingCategoryPassengerSpecificationDto(pspec.categoryId, Math.max(1, pspec.passengers)));
                    }
                }
            }

            if ( segmentSpec.passengerSpecifications.isEmpty() ) {
                return new SegmentPassengerSpecificationDto(fareClassId, new PricingCategoryPassengerSpecificationDto(route.findDefaultPricingCategory().id, Math.max(1, query.passengers)));
            } else {
                return segmentSpec;
            }
        }
    }

    @JsonIgnore
    public List<RouteDto> getRoutes() {
        List<RouteDto> routes = new ArrayList<>();
        routes.addAll(departurePath.getRoutes());
        if ( returnPath != null ) {
            for (RouteDto route : returnPath.getRoutes()) {
                if ( !routes.contains(route) ) {
                    routes.add(route);
                }
            }
        }
        return routes;
    }

    @JsonIgnore
    public RouteDto getRoute() {
        return getRoutes().iterator().next();
    }

    @JsonIgnore
    public Double getTotalPrice(TransportQuery query) {
        Double total = null;
        for (AvailablePathSegmentDto segment : getRouteSegments(query)) {
            if ( segment.getTotalPrice() != null ) {
                if ( total == null ) {
                    total = 0d;
                }
                total += segment.getTotalPrice();
            } else {
                return null;
            }
        }
        return total;
    }

    @JsonIgnore
    public int getTotalLegs() {
        return departurePath.legs.size() + (returnPath != null ? returnPath.legs.size() : 0);
    }

    @JsonIgnore
    public long getTotalDuration(TimeUnit unit) {
        return departurePath.getDuration(unit) + (returnPath != null ? returnPath.getDuration(unit) : 0);
    }
}
