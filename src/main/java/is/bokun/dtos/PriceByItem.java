package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceByItem {

    public int id;
    public SimpleMoney amount;
    public List<PriceByItem> prices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SimpleMoney getAmount() {
        return amount;
    }

    public void setAmount(SimpleMoney amount) {
        this.amount = amount;
    }

    public List<PriceByItem> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceByItem> prices) {
        this.prices = prices;
    }
}
