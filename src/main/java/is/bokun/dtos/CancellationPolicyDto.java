package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CancellationPolicyDto {

    public int id;
    public String title;
    public List<PenaltyRuleDto> penaltyRules;
    public TaxDto tax;

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

    public List<PenaltyRuleDto> getPenaltyRules() {
        return penaltyRules;
    }

    public void setPenaltyRules(List<PenaltyRuleDto> penaltyRules) {
        this.penaltyRules = penaltyRules;
    }

    public TaxDto getTax() {
        return tax;
    }

    public void setTax(TaxDto tax) {
        this.tax = tax;
    }
}
