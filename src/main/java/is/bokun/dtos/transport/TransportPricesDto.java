package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 3.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "TransportPrices")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransportPricesDto {

    @XmlElementWrapper
    @XmlElement(name="passengerCategoryPrices")
    public List<PassengerCategoryPricesDto> priceList = new ArrayList<>();

    public Double getTotalPrice(SegmentPassengerSpecificationDto segmentPassengerSpec, boolean peak, boolean returnTicket) {
        Double total = null;
        for (PassengerPriceSpecificationDto p : getPrices(segmentPassengerSpec, peak, returnTicket)) {
            if ( p.getTotalPrice() != null ) {
                if ( total == null ) {
                    total = 0d;
                }
                total += p.getTotalPrice();
            } else {
                return null;
            }
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
