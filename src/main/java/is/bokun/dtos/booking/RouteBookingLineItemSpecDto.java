package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.dtos.transport.FareClassDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 24.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PassengerSpecification")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteBookingLineItemSpecDto {

    public FareClassDto fareClass;
    public PricingCategoryDto pricingCategory;
    public Double pricePerPassenger;
    public int quantity;

    public RouteBookingLineItemSpecDto() {}

    public RouteBookingLineItemSpecDto(PricingCategoryDto pricingCategory, FareClassDto fareClass, int quantity) {
        this.pricingCategory = pricingCategory;
        this.fareClass = fareClass;
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        if ( pricePerPassenger == null ) {
            return null;
        } else {
            return quantity * pricePerPassenger;
        }
    }

}
