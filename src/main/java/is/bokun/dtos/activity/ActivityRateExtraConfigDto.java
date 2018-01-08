package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityRateExtraConfigDto {

    public int id;
    public int activityExtraId;
    public SelectionTypeEnum selectionType;
    public PricingTypeEnum pricingType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityExtraId() {
        return activityExtraId;
    }

    public void setActivityExtraId(int activityExtraId) {
        this.activityExtraId = activityExtraId;
    }

    public SelectionTypeEnum getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(SelectionTypeEnum selectionType) {
        this.selectionType = selectionType;
    }

    public PricingTypeEnum getPricingType() {
        return pricingType;
    }

    public void setPricingType(PricingTypeEnum pricingType) {
        this.pricingType = pricingType;
    }
}
