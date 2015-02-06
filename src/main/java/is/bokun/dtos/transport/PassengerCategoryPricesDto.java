package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.dtos.pricing.PriceModulationOutput;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 4/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PassengerCategoryPrices")
@XmlAccessorType(XmlAccessType.FIELD)
public class PassengerCategoryPricesDto {

    public PricingCategoryDto pricingCategory;
    public FareClassDto fareClass;
    public boolean peak;
    public boolean returnTicket;

    public PriceModulationOutput price;

    public PassengerCategoryPricesDto() {}

    public PassengerCategoryPricesDto(PricingCategoryDto pricingCategory, FareClassDto fareClass, boolean peak, boolean returnTicket, PriceModulationOutput price) {
        this.pricingCategory = pricingCategory;
        this.fareClass = fareClass;
        this.price = price;
        this.peak = peak;
        this.returnTicket = returnTicket;
    }

}
