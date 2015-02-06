package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.dtos.transport.FareClassDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 09/01/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RoutePassengerBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoutePassengerBookingDto {

    public Long id;
    public PricingCategoryDto pricingCategory;
    public FareClassDto fareClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PricingCategoryDto getPricingCategory() {
        return pricingCategory;
    }

    public void setPricingCategory(PricingCategoryDto pricingCategory) {
        this.pricingCategory = pricingCategory;
    }

    public FareClassDto getFareClass() {
        return fareClass;
    }

    public void setFareClass(FareClassDto fareClass) {
        this.fareClass = fareClass;
    }
}
