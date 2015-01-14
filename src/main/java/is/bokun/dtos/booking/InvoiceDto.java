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
    @XmlElement(name="payment")
    public List<PaymentDto> payments = new ArrayList<>();

    public List<LineItemDto> getItems() {
        return items;
    }

    public void setItems(List<LineItemDto> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalSansDiscount() {
        return totalSansDiscount;
    }

    public void setTotalSansDiscount(double totalSansDiscount) {
        this.totalSansDiscount = totalSansDiscount;
    }

    public double getTotalSansCommission() {
        return totalSansCommission;
    }

    public void setTotalSansCommission(double totalSansCommission) {
        this.totalSansCommission = totalSansCommission;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<PaymentDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDto> payments) {
        this.payments = payments;
    }
}
