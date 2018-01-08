package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.PriceByItem;
import is.bokun.dtos.SimpleMoney;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityRatePrices {

    public int activityRateId;
    public SimpleMoney pricePerBooking;
    public List<PriceByItem> pricePerCategoryUnit;
    public SimpleMoney pickupPrice;
    public List<PriceByItem> pickupPricePerCategoryUnit;
    public SimpleMoney dropoffPrice;
    public List<PriceByItem> dropoffPricePerCategoryUnit;
    public List<PriceByItem> extraPricePerUnit;
    public List<PriceByItem> extraPricePerCategoryUnit;

    public int getActivityRateId() {
        return activityRateId;
    }

    public void setActivityRateId(int activityRateId) {
        this.activityRateId = activityRateId;
    }

    public SimpleMoney getPricePerBooking() {
        return pricePerBooking;
    }

    public void setPricePerBooking(SimpleMoney pricePerBooking) {
        this.pricePerBooking = pricePerBooking;
    }

    public List<PriceByItem> getPricePerCategoryUnit() {
        return pricePerCategoryUnit;
    }

    public void setPricePerCategoryUnit(List<PriceByItem> pricePerCategoryUnit) {
        this.pricePerCategoryUnit = pricePerCategoryUnit;
    }

    public SimpleMoney getPickupPrice() {
        return pickupPrice;
    }

    public void setPickupPrice(SimpleMoney pickupPrice) {
        this.pickupPrice = pickupPrice;
    }

    public List<PriceByItem> getPickupPricePerCategoryUnit() {
        return pickupPricePerCategoryUnit;
    }

    public void setPickupPricePerCategoryUnit(List<PriceByItem> pickupPricePerCategoryUnit) {
        this.pickupPricePerCategoryUnit = pickupPricePerCategoryUnit;
    }

    public SimpleMoney getDropoffPrice() {
        return dropoffPrice;
    }

    public void setDropoffPrice(SimpleMoney dropoffPrice) {
        this.dropoffPrice = dropoffPrice;
    }

    public List<PriceByItem> getDropoffPricePerCategoryUnit() {
        return dropoffPricePerCategoryUnit;
    }

    public void setDropoffPricePerCategoryUnit(List<PriceByItem> dropoffPricePerCategoryUnit) {
        this.dropoffPricePerCategoryUnit = dropoffPricePerCategoryUnit;
    }

    public List<PriceByItem> getExtraPricePerUnit() {
        return extraPricePerUnit;
    }

    public void setExtraPricePerUnit(List<PriceByItem> extraPricePerUnit) {
        this.extraPricePerUnit = extraPricePerUnit;
    }

    public List<PriceByItem> getExtraPricePerCategoryUnit() {
        return extraPricePerCategoryUnit;
    }

    public void setExtraPricePerCategoryUnit(List<PriceByItem> extraPricePerCategoryUnit) {
        this.extraPricePerCategoryUnit = extraPricePerCategoryUnit;
    }
}
