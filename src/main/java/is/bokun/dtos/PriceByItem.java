package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceByItem {

    public int id;
    public Long amount;
    public List<PriceByItem> prices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<PriceByItem> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceByItem> prices) {
        this.prices = prices;
    }
}
