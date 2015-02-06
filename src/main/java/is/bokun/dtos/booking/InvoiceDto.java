package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sindri Traustason
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "invoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceDto {


    public List<LineItemDto> items = new ArrayList<>();

    public double total;

    public double totalDiscount;

    public double totalSansDiscount;

    public double totalSansCommission;

    public double totalCommission;

    public String currency;

    @XmlElementWrapper
    @XmlElement(name="settlement")
    public List<SettlementDto> settlements = new ArrayList<>();
}
