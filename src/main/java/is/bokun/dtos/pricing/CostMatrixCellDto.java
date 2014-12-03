package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 12.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "CostMatrixCell")
@XmlAccessorType(XmlAccessType.FIELD)
public class CostMatrixCellDto {

    public Long id;
    public Long fromAxisItemId, toAxisItemId;
    public String itemId;
    public String externalId;

    @XmlElement(name="cellPrice")
    public List<CellPriceDto> prices = new ArrayList<>();

    @JsonIgnore
    public CellPriceDto findPriceByDateRange(Long dateRangeId, String currency) {
        for (CellPriceDto price : prices) {
            if ( price.getDateRangeId().equals(dateRangeId) && price.getCurrency().equalsIgnoreCase(currency) ) {
                return price;
            }
        }
        return null;
    }
}
