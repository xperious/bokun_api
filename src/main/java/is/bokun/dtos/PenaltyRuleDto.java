package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PenaltyRuleDto {

    public int id;
    public int cutoffHours;
    public Long charge;
    public String chargeType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCutoffHours() {
        return cutoffHours;
    }

    public void setCutoffHours(int cutoffHours) {
        this.cutoffHours = cutoffHours;
    }

    public Long getCharge() {
        return charge;
    }

    public void setCharge(Long charge) {
        this.charge = charge;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }
}
