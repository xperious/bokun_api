package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.AvailabilityClosureDto;
import is.bokun.dtos.AvailabilityExpressionDto;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.dtos.ProductDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "Route")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteDto extends ProductDto {

    public boolean peakPricing;
    public boolean fareClassPricing;
    public boolean fareClassCapacity;
    public boolean returnPricing;
    public boolean flexibleTickets;
    public boolean timeSelectionRequired;

    public List<String> flags = new ArrayList<>();
    public List<RouteLegDto> legs = new ArrayList<>();
    public List<PricingCategoryDto> pricingCategories = new ArrayList<>();
    public List<FareClassDto> fareClasses;
    public List<Long> endStationIds;

    public List<AvailabilityExpressionDto> availabilityExpressions = new ArrayList<>();
    public List<AvailabilityClosureDto> closures = new ArrayList<>();

    public RouteDto() {}

    public RouteDto(String title) {
        this.title = title;
    }

    public void setPeakPricing(boolean peakPricing) {
        this.peakPricing = peakPricing;
    }

    public void setFareClassPricing(boolean fareClassPricing) {
        this.fareClassPricing = fareClassPricing;
    }

    public void setFareClassCapacity(boolean fareClassCapacity) {
        this.fareClassCapacity = fareClassCapacity;
    }

    public void setFlexibleTickets(boolean flexibleTickets) {
        this.flexibleTickets = flexibleTickets;
    }

    public void setTimeSelectionRequired(boolean timeSelectionRequired) {
        this.timeSelectionRequired = timeSelectionRequired;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public List<RouteLegDto> getLegs() {
        return legs;
    }

    public void setLegs(List<RouteLegDto> legs) {
        this.legs = legs;
    }

    public List<PricingCategoryDto> getPricingCategories() {
        return pricingCategories;
    }

    public void setPricingCategories(List<PricingCategoryDto> pricingCategories) {
        this.pricingCategories = pricingCategories;
    }

    public List<FareClassDto> getFareClasses() {
        return fareClasses;
    }

    public void setFareClasses(List<FareClassDto> fareClasses) {
        this.fareClasses = fareClasses;
    }

    public List<Long> getEndStationIds() {
        return endStationIds;
    }

    public void setEndStationIds(List<Long> endStationIds) {
        this.endStationIds = endStationIds;
    }

    public List<AvailabilityExpressionDto> getAvailabilityExpressions() {
        return availabilityExpressions;
    }

    public void setAvailabilityExpressions(List<AvailabilityExpressionDto> availabilityExpressions) {
        this.availabilityExpressions = availabilityExpressions;
    }

    public List<AvailabilityClosureDto> getClosures() {
        return closures;
    }

    public void setClosures(List<AvailabilityClosureDto> closures) {
        this.closures = closures;
    }

    @JsonIgnore
    public RouteLegDto findLegById(Long legId) {
        for (RouteLegDto legDto : legs) {
            if ( legDto.id.equals(legId) ) {
                return legDto;
            }
        }
        return null;
    }

    @JsonIgnore
    public FareClassDto findFareClassById(Long fareClassId) {
        for (FareClassDto fareClass : fareClasses) {
            if ( fareClass.id.equals(fareClassId) ) {
                return fareClass;
            }
        }
        return null;
    }

    @JsonIgnore
    public List<PricingCategoryDto> getPublicPricingCategories() {
        return getPublicPricingCategories(null);
    }

    @JsonIgnore
    public List<PricingCategoryDto> getPublicPricingCategories(Set<Long> ids) {
        List<PricingCategoryDto> list = new ArrayList<>();
        for (PricingCategoryDto pcat : pricingCategories) {
            if ( !pcat.internalUseOnly && (ids == null || ids.contains(pcat.id)) ) {
                list.add(pcat);
            }
        }
        return list;
    }

    @JsonIgnore
    public PricingCategoryDto findDefaultPricingCategory() {
        for (PricingCategoryDto pcat : getPublicPricingCategories()) {
            if ( pcat.defaultCategory ) {
                return pcat;
            }
        }
        return null;
    }

    @JsonIgnore
    public PricingCategoryDto findPricingCategoryById(Long pcatId) {
        for (PricingCategoryDto pcat : pricingCategories) {
            if ( pcat.id.equals(pcatId) ) {
                return pcat;
            }
        }
        return null;
    }

    @JsonIgnore
    public boolean hasPricingCategory(Long pcatId) {
        for (PricingCategoryDto pcat : getPublicPricingCategories()) {
            if ( pcat.id.equals(pcatId) ) {
                return true;
            }
        }
        return false;
    }


}
