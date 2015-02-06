package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import is.bokun.dtos.CapacityDto;
import is.bokun.dtos.CapacityTypeEnum;
import is.bokun.queries.TransportQuery;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ogg on 17.9.2014.
 */
public class AvailablePathSegmentDto {

    public RouteDto route;
    public boolean returning; // specifies whether this segment is part of a return path
    public List<AvailableLegDto> departurePath = new ArrayList<>();
    public List<AvailableLegDto> returnPath = null;

    public SegmentPassengerSpecificationDto passengerSpecification;

    public AvailablePathSegmentDto(RouteDto route, boolean returning, SegmentPassengerSpecificationDto passengerSpecification) {
        this.route = route;
        this.returning = returning;
        this.passengerSpecification = passengerSpecification;
    }

    @JsonIgnore
    public List<Long> getDepartureStationIds() {
        List<Long> list = new ArrayList<>();
        for (AvailableLegDto leg : departurePath) {
            list.add(leg.leg.from.id);
            list.add(leg.leg.to.id);
        }
        return list;
    }

    @JsonIgnore
    public CapacityDto findMinimumCapacity(TransportQuery query) {
        if ( route.fareClassCapacity ) {
            if (query.hasFareClass() && route.findFareClassById(query.fareClassId) != null ) {
                return findMinimumCapacity(query.fareClassId);
            } else {
                return findMinimumCapacity(route.findDefaultFareClass().id);
            }
        } else {
            return findMinimumCapacity();
        }
    }

    @JsonIgnore
    public CapacityDto findMinimumCapacity() {
        return findMinimumCapacity((Long)null);
    }

    @JsonIgnore
    public CapacityDto findMinimumCapacity(Long fareClassId) {
        CapacityDto c = null;
        for (AvailableLegDto leg : departurePath) {
            for (AvailableSeatsDto seats : leg.departure.availableSeats) {
                if ( fareClassId == null || ("fareclass_" + fareClassId).equals(seats.fareClassId) ) {
                    if ( c == null || (seats.capacity.capacityType != CapacityTypeEnum.UNLIMITED && seats.capacity.capacity < c.capacity)) {
                        c = seats.capacity;
                    }
                }
            }
        }
        if ( !returning && returnPath != null ) {
            for (AvailableLegDto leg : returnPath) {
                for (AvailableSeatsDto seats : leg.departure.availableSeats) {
                    if ( fareClassId == null || ("fareclass_" + fareClassId).equals(seats.fareClassId) ) {
                        if ( c == null || (seats.capacity.capacityType != CapacityTypeEnum.UNLIMITED && seats.capacity.capacity < c.capacity)) {
                            c = seats.capacity;
                        }
                    }
                }
            }
        }

        if ( c == null ) {
            return new CapacityDto(CapacityTypeEnum.LIMITED, 0);
        } else {
            if ( c.capacityType == CapacityTypeEnum.UNLIMITED ) {
                c.capacity = 25;
            }
            return c;
        }
    }

    @JsonIgnore
    public List<FareClassDto> getAvailableFareClasses() {
        Set<String> departureFareClassIds = new HashSet<>();
        for (AvailableLegDto leg : departurePath) {
            for (AvailableSeatsDto seats : leg.departure.availableSeats) {
                if ( seats.fareClassId != null ) {
                    departureFareClassIds.add(seats.fareClassId);
                }
            }
        }

        Set<String> returnFareClassIds = new HashSet<>();
        if ( !returning && returnPath != null ) {
            for (AvailableLegDto leg : returnPath) {
                for (AvailableSeatsDto seats : leg.departure.availableSeats) {
                    if ( seats.fareClassId != null ) {
                        returnFareClassIds.add(seats.fareClassId);
                    }
                }
            }
        }

        Set<String> fareClassIds = (!returning && returnPath != null)
                ? Sets.intersection(departureFareClassIds, returnFareClassIds)
                : departureFareClassIds
                ;

        List<FareClassDto> list = new ArrayList<>();
        for (FareClassDto fc : route.fareClasses) {
            if ( fareClassIds.contains("fareclass_" + fc.id) ) {
                list.add(fc);
            }
        }
        return list;
    }

    @JsonIgnore
    public Double getPricePerPerson(Long pricingCategoryId) {
        return getPricePerPerson(pricingCategoryId, passengerSpecification.fareClassId);
    }

    @JsonIgnore
    public Double getPricePerPerson(Long pricingCategoryId, Long fareClassId) {
        if ( fareClassId != null && fareClassId > 0 ) {
            FareClassDto fareClass = route.findFareClassById(fareClassId);
            if ( fareClass == null ) {
                throw new RuntimeException("No such fare class [" + fareClassId + "] in route [" + route.id + "]");
            }
        }
        double totalPrice = 0d;
        for (AvailableLegDto leg : departurePath) {
            boolean useReturnPricing = returnPath != null && !returnPath.isEmpty() && route.returnPricing;
            boolean usePeakPricing = leg.departure.schedule.peak && route.peakPricing;
            TransportPricesDto prices = leg.departure.getPrices();
            PassengerPriceSpecificationDto price = prices.getPrice(1, pricingCategoryId, fareClassId, usePeakPricing, useReturnPricing);
            if ( price != null && price.price.foundPrice ) {
                totalPrice += price.price.getPriceWithDiscount();
            } else {
                return null;
            }
        }
        return totalPrice;
    }

    @JsonIgnore
    public Double getTotalPrice() {
        Double total = null;
        for (AvailableLegDto leg : departurePath) {
            boolean useReturnPricing = returnPath != null && !returnPath.isEmpty() && route.returnPricing;
            boolean usePeakPricing = leg.departure.schedule.peak && route.peakPricing;
            Double legPrice = leg.departure.getPrices().getTotalPrice(passengerSpecification, usePeakPricing, useReturnPricing);
            if ( legPrice != null ) {
                if ( total == null ) {
                    total = 0d;
                }
                total += leg.departure.getPrices().getTotalPrice(passengerSpecification, usePeakPricing, useReturnPricing);
            } else {
                return null;
            }
        }
        return total;
    }
}
