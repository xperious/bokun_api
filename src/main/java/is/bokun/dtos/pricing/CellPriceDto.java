package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 12.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "CellPrice")
@XmlAccessorType(XmlAccessType.FIELD)
public class CellPriceDto {

    public Double amount;
    public String currency;

    public Long cellId;
    public Long dateRangeId;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public Long getDateRangeId() {
        return dateRangeId;
    }

    public void setDateRangeId(Long dateRangeId) {
        this.dateRangeId = dateRangeId;
    }

    @JsonIgnore
    public CellPriceDto clone() {
        CellPriceDto clone = new CellPriceDto();
        clone.amount = amount;
        clone.currency = currency;
        clone.cellId = cellId;
        clone.dateRangeId = dateRangeId;
        return clone;
    }
}
