package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.pricing.CostItemTypeEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Sindri Traustason
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "lineItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineItemDto {

    public String title;
    public int items;
    public int quantity;
    public double price;
    public double total;
    public CostItemTypeEnum type;
    public double discount;
}
