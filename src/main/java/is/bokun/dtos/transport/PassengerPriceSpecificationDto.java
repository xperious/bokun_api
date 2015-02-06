package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ogg on 17.9.2014.
 */
public class PassengerPriceSpecificationDto extends PassengerCategoryPricesDto {

    public int passengers;

    public PassengerPriceSpecificationDto(PassengerCategoryPricesDto catPrices, int passengers) {
        this.passengers = passengers;
        this.pricingCategory = catPrices.pricingCategory;
        this.fareClass = catPrices.fareClass;
        this.peak = catPrices.peak;
        this.price = catPrices.price;
        this.returnTicket = catPrices.returnTicket;
    }

    @JsonIgnore
    public Double getTotalPrice() {
        return price.foundPrice ? passengers * price.getPriceWithDiscount() : null;
    }
}
