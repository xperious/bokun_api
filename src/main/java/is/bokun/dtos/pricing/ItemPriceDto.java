package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "ItemPrice")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemPriceDto {

    public double amount;
    public String currency;

    public Long costItemId;
    public Long dateRangeId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCostItemId() {
        return costItemId;
    }

    public void setCostItemId(Long costItemId) {
        this.costItemId = costItemId;
    }

    public Long getDateRangeId() {
        return dateRangeId;
    }

    public void setDateRangeId(Long dateRangeId) {
        this.dateRangeId = dateRangeId;
    }
}
