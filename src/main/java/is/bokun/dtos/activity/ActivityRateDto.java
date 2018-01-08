package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import is.bokun.dtos.CancellationPolicyDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityRateDto {

    public int id;
    public String title;
    public String description;
    public int index;
    public String rateCode;
    public boolean pricedPerPerson;
    public int minPerBooking;
    public int maxPerBooking;
    public CancellationPolicyDto cancellationPolicy;
    public SelectionTypeEnum pickupSelectionType;
    public PricingTypeEnum pickupPricingType;
    public boolean pickupPricedPerPerson;
    public SelectionTypeEnum dropoffSelectionType;
    public PricingTypeEnum dropoffPricingType;
    public boolean dropoffPricedPerPerson;
    public List<Integer> startTimeIds;
    public List<Integer> pricingCategoryIds;
    public List<ActivityRateExtraConfigDto> extraConfigs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public boolean isPricedPerPerson() {
        return pricedPerPerson;
    }

    public void setPricedPerPerson(boolean pricedPerPerson) {
        this.pricedPerPerson = pricedPerPerson;
    }

    public int getMinPerBooking() {
        return minPerBooking;
    }

    public void setMinPerBooking(int minPerBooking) {
        this.minPerBooking = minPerBooking;
    }

    public int getMaxPerBooking() {
        return maxPerBooking;
    }

    public void setMaxPerBooking(int maxPerBooking) {
        this.maxPerBooking = maxPerBooking;
    }

    public CancellationPolicyDto getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(CancellationPolicyDto cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public SelectionTypeEnum getPickupSelectionType() {
        return pickupSelectionType;
    }

    public void setPickupSelectionType(SelectionTypeEnum pickupSelectionType) {
        this.pickupSelectionType = pickupSelectionType;
    }

    public PricingTypeEnum getPickupPricingType() {
        return pickupPricingType;
    }

    public void setPickupPricingType(PricingTypeEnum pickupPricingType) {
        this.pickupPricingType = pickupPricingType;
    }

    public boolean isPickupPricedPerPerson() {
        return pickupPricedPerPerson;
    }

    public void setPickupPricedPerPerson(boolean pickupPricedPerPerson) {
        this.pickupPricedPerPerson = pickupPricedPerPerson;
    }

    public SelectionTypeEnum getDropoffSelectionType() {
        return dropoffSelectionType;
    }

    public void setDropoffSelectionType(SelectionTypeEnum dropoffSelectionType) {
        this.dropoffSelectionType = dropoffSelectionType;
    }

    public PricingTypeEnum getDropoffPricingType() {
        return dropoffPricingType;
    }

    public void setDropoffPricingType(PricingTypeEnum dropoffPricingType) {
        this.dropoffPricingType = dropoffPricingType;
    }

    public boolean isDropoffPricedPerPerson() {
        return dropoffPricedPerPerson;
    }

    public void setDropoffPricedPerPerson(boolean dropoffPricedPerPerson) {
        this.dropoffPricedPerPerson = dropoffPricedPerPerson;
    }

    public List<Integer> getStartTimeIds() {
        return startTimeIds;
    }

    public void setStartTimeIds(List<Integer> startTimeIds) {
        this.startTimeIds = startTimeIds;
    }

    public List<Integer> getPricingCategoryIds() {
        return pricingCategoryIds;
    }

    public void setPricingCategoryIds(List<Integer> pricingCategoryIds) {
        this.pricingCategoryIds = pricingCategoryIds;
    }

    public List<ActivityRateExtraConfigDto> getExtraConfigs() {
        return extraConfigs;
    }

    public void setExtraConfigs(List<ActivityRateExtraConfigDto> extraConfigs) {
        this.extraConfigs = extraConfigs;
    }
}
