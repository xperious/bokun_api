package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.transport.PricingCategoryPassengerSpecificationDto;
import is.bokun.utils.StringUtils;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TransportQuery {

    public List<PricingCategoryPassengerSpecificationDto> pricingCategories = new ArrayList<>();
    public Long fareClassId;
    public int passengers;

    public String departureDate;
    public String returnDate;

    public String departureTime;
    public String returnTime;

    public Long sourceStationId, destStationId;
    public Long sourcePickupPlaceId, destPickupPlaceId;

    public List<Long> routeIds = new ArrayList<>();

    public int maxRoutes, maxLegs = 0;
    public int maxPaths = 5;

    public String maxTotalDuration, maxStopoverDuration;

    public RouteWeightType weightType = RouteWeightType.PRICE;

    @JsonIgnore
    public boolean hasFareClass() {
        return fareClassId != null && fareClassId > 0;
    }

    @JsonIgnore
    public boolean hasPricingCategories() {
        return pricingCategories != null && !pricingCategories.isEmpty();
    }

    @JsonIgnore
    public Set<Long> getPricingCategoryIds() {
        Set<Long> ids = new HashSet<>();
        if ( hasPricingCategories() ) {
            for (PricingCategoryPassengerSpecificationDto spec : pricingCategories) {
                ids.add(spec.categoryId);
            }
        }
        return ids;
    }

    @JsonIgnore
    public PricingCategoryPassengerSpecificationDto getPricingCategorySpec(Long pricingCategoryId) {
        for (PricingCategoryPassengerSpecificationDto spec : pricingCategories) {
            if ( spec.categoryId.equals(pricingCategoryId) ) {
                return spec;
            }
        }
        return null;
    }

    @JsonIgnore
    public int passengerCountForPricingCategory(Long pricingCategoryId) {
        PricingCategoryPassengerSpecificationDto spec = getPricingCategorySpec(pricingCategoryId);
        return spec != null ? spec.passengers : 0;
    }

    @JsonIgnore
    public LocalDate getDepartureDateParsed() {
        if ( !StringUtils.isNullOrEmpty(departureDate) ) {
            try {
                return LocalDate.parse(departureDate);
            } catch (Throwable ignored){}
        }
        return null;
    }

    @JsonIgnore
    public LocalTime getDepartureTimeParsed() {
        if ( !StringUtils.isNullOrEmpty(departureTime) ) {
            try {
                return LocalTime.parse(departureTime);
            } catch (Throwable ignored){}
        }
        return null;
    }

    @JsonIgnore
    public LocalDate getReturnDateParsed() {
        if ( !StringUtils.isNullOrEmpty(returnDate) ) {
            try {
                return LocalDate.parse(returnDate);
            } catch (Throwable ignored){}
        }
        return null;
    }

    @JsonIgnore
    public LocalTime getReturnTimeParsed() {
        if ( !StringUtils.isNullOrEmpty(returnTime) ) {
            try {
                return LocalTime.parse(returnTime);
            } catch (Throwable ignored){}
        }
        return null;
    }

    @JsonIgnore
    public Duration getMaxTotalDurationParsed() {
        if ( !StringUtils.isNullOrEmpty(maxTotalDuration) ) {
            try {
                return Duration.parse(maxTotalDuration);
            } catch (Throwable ignored){}
        }
        return null;
    }

    @JsonIgnore
    public Duration getMaxStopoverDurationParsed() {
        if ( !StringUtils.isNullOrEmpty(maxStopoverDuration) ) {
            try {
                return Duration.parse(maxStopoverDuration);
            } catch (Throwable ignored){}
        }
        return null;
    }

    public List<PricingCategoryPassengerSpecificationDto> getPricingCategories() {
        return pricingCategories;
    }

    public void setPricingCategories(List<PricingCategoryPassengerSpecificationDto> pricingCategories) {
        this.pricingCategories = pricingCategories;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Long getFareClassId() {
        return fareClassId;
    }

    public void setFareClassId(Long fareClassId) {
        this.fareClassId = fareClassId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public int getMaxRoutes() {
        return maxRoutes;
    }

    public void setMaxRoutes(int maxRoutes) {
        this.maxRoutes = maxRoutes;
    }

    public int getMaxLegs() {
        return maxLegs;
    }

    public void setMaxLegs(int maxLegs) {
        this.maxLegs = maxLegs;
    }

    public int getMaxPaths() {
        return maxPaths;
    }

    public void setMaxPaths(int maxPaths) {
        this.maxPaths = maxPaths;
    }

    public String getMaxTotalDuration() {
        return maxTotalDuration;
    }

    public void setMaxTotalDuration(String maxTotalDuration) {
        this.maxTotalDuration = maxTotalDuration;
    }

    public String getMaxStopoverDuration() {
        return maxStopoverDuration;
    }

    public void setMaxStopoverDuration(String maxStopoverDuration) {
        this.maxStopoverDuration = maxStopoverDuration;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Long getSourceStationId() {
        return sourceStationId;
    }

    public void setSourceStationId(Long sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public Long getDestStationId() {
        return destStationId;
    }

    public void setDestStationId(Long destStationId) {
        this.destStationId = destStationId;
    }

    public Long getSourcePickupPlaceId() {
        return sourcePickupPlaceId;
    }

    public void setSourcePickupPlaceId(Long sourcePickupPlaceId) {
        this.sourcePickupPlaceId = sourcePickupPlaceId;
    }

    public Long getDestPickupPlaceId() {
        return destPickupPlaceId;
    }

    public void setDestPickupPlaceId(Long destPickupPlaceId) {
        this.destPickupPlaceId = destPickupPlaceId;
    }

    public List<Long> getRouteIds() {
        return routeIds;
    }

    public void setRouteIds(List<Long> routeIds) {
        this.routeIds = routeIds;
    }

    public RouteWeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(RouteWeightType weightType) {
        this.weightType = weightType;
    }

}
