package is.bokun.dtos.transport;

import is.bokun.queries.TransportQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 3.9.2014.
 */
public class TransportPricesDto {

    public List<PassengerCategoryPricesDto> priceList = new ArrayList<>();

    public Double getTotalPrice(SegmentPassengerSpecificationDto segmentPassengerSpec, boolean peak, boolean returnTicket) {
        Double total = 0d;
        for (PassengerPriceSpecificationDto p : getPrices(segmentPassengerSpec, peak, returnTicket)) {
            total += p.getTotalPrice();
        }
        return total;
    }

    public List<PassengerPriceSpecificationDto> getPrices(SegmentPassengerSpecificationDto segmentPassengerSpec, boolean peak, boolean returnTicket) {
        List<PassengerPriceSpecificationDto> list = new ArrayList<>();
        for (PricingCategoryPassengerSpecificationDto pspec : segmentPassengerSpec.passengerSpecifications) {
            PassengerPriceSpecificationDto price = getPrice(pspec.passengers, pspec.categoryId, segmentPassengerSpec.fareClassId, peak, returnTicket);
            if ( price != null ) {
                list.add(price);
            }
        }
        return list;
    }

    public PassengerPriceSpecificationDto getPrice(int passengers, Long pricingCategoryId, Long fareClassId, boolean peak, boolean returnTicket) {

        for (PassengerCategoryPricesDto passengerPrice : priceList) {
            if ( passengerPrice.pricingCategory.id.equals(pricingCategoryId) ) {
                if ((fareClassId != null && fareClassId > 0) && passengerPrice.fareClass != null && passengerPrice.fareClass.id.equals(fareClassId)) {
                    // price for a particular fare class
                    PassengerPriceSpecificationDto prices = getPriceAmount(passengerPrice, peak, returnTicket, passengers);
                    if ( prices != null ) {
                        return prices;
                    }
                } else if ( (fareClassId == null || fareClassId <= 0) && (passengerPrice.fareClass == null || passengerPrice.fareClass.defaultClass) ) {
                    // get price for default fare class (if any)
                    PassengerPriceSpecificationDto prices = getPriceAmount(passengerPrice, peak, returnTicket, passengers);
                    if ( prices != null ) {
                        return prices;
                    }
                }
            }
        }

        return null;
    }

    private PassengerPriceSpecificationDto getPriceAmount(PassengerCategoryPricesDto passengerPrice, boolean peak, boolean returnTicket, int passengers) {
        if ( returnTicket ) {
            if (peak && passengerPrice.peak && passengerPrice.returnTicket) {
                return new PassengerPriceSpecificationDto(passengerPrice, passengers);
            } else if (!peak && !passengerPrice.peak && passengerPrice.returnTicket) {
                return new PassengerPriceSpecificationDto(passengerPrice, passengers);
            }
        } else {
            if (peak && passengerPrice.peak) {
                return new PassengerPriceSpecificationDto(passengerPrice, passengers);
            } else if (!peak && !passengerPrice.peak) {
                return new PassengerPriceSpecificationDto(passengerPrice, passengers);
            }
        }
        return null;
    }
}
