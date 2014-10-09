package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import is.bokun.dtos.CapacityDto;
import is.bokun.dtos.CapacityTypeEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ogg on 17.9.2014.
 */
public class AvailablePathSegmentDto {

    public RouteDto route;
    public boolean returning;
    public List<AvailableLegDto> departurePath = new ArrayList<>();
    public List<AvailableLegDto> returnPath = new ArrayList<>();

    public SegmentPassengerSpecificationDto passengerSpecification;

    public AvailablePathSegmentDto() {}

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
    public CapacityDto findMinimumCapacity() {
        return findMinimumCapacity(null);
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

        Set<String> fareClassIds = Sets.intersection(departureFareClassIds, returnFareClassIds);

        List<FareClassDto> unfiltered = route.fareClasses;
        List<FareClassDto> list = new ArrayList<>();
        for (FareClassDto fc : unfiltered) {
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
            if ( price != null ) {
                totalPrice += price.price;
            } else {
                throw new RuntimeException("Could not find price");
            }
        }
        return totalPrice;
    }

    @JsonIgnore
    public Double getTotalPrice() {
        Double total = 0d;
        for (AvailableLegDto leg : departurePath) {
            boolean useReturnPricing = returnPath != null && !returnPath.isEmpty() && route.returnPricing;
            boolean usePeakPricing = leg.departure.schedule.peak && route.peakPricing;
            total += leg.departure.getPrices().getTotalPrice(passengerSpecification, usePeakPricing, useReturnPricing);
        }
        return total;
    }
}
