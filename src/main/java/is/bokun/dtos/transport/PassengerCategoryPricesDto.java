package is.bokun.dtos.transport;

import is.bokun.dtos.PricingCategoryDto;

/**
 * Created by ogg on 4/9/14.
 */
public class PassengerCategoryPricesDto {

    public PricingCategoryDto pricingCategory;
    public FareClassDto fareClass;
    public boolean peak;
    public boolean returnTicket;

    public Double price;

    public PassengerCategoryPricesDto() {}

    public PassengerCategoryPricesDto(PricingCategoryDto pricingCategory, Double price) {
        this.pricingCategory = pricingCategory;
        this.price = price;
        this.peak = false;
        this.returnTicket = false;
    }

    public PassengerCategoryPricesDto(PricingCategoryDto pricingCategory, FareClassDto fareClass, Double price) {
        this.pricingCategory = pricingCategory;
        this.fareClass = fareClass;
        this.price = price;
        this.peak = false;
    }

    public PassengerCategoryPricesDto(PricingCategoryDto pricingCategory, FareClassDto fareClass, boolean peak, boolean returnTicket, Double price) {
        this.pricingCategory = pricingCategory;
        this.fareClass = fareClass;
        this.price = price;
        this.peak = peak;
        this.returnTicket = returnTicket;
    }

    public static PassengerCategoryPricesDto returnTicket(PricingCategoryDto pricingCategory, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, null, false, true, price);
    }

    public static PassengerCategoryPricesDto returnTicket(PricingCategoryDto pricingCategory, FareClassDto fareClass, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, fareClass, false, true, price);
    }

    public static PassengerCategoryPricesDto peak(PricingCategoryDto pricingCategory, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, null, true, false, price);
    }

    public static PassengerCategoryPricesDto peak(PricingCategoryDto pricingCategory, FareClassDto fareClass, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, fareClass, true, false, price);
    }

    public static PassengerCategoryPricesDto peakReturn(PricingCategoryDto pricingCategory, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, null, true, true, price);
    }

    public static PassengerCategoryPricesDto peakReturn(PricingCategoryDto pricingCategory, FareClassDto fareClass, Double price) {
        return new PassengerCategoryPricesDto(pricingCategory, fareClass, true, true, price);
    }
}
