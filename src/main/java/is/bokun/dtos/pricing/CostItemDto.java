package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CostItemDto {

    public Long id;
    public String title;
    public CostItemTypeEnum itemType;
    public String itemId;
    public int sortIndex;

    public List<ItemPriceDto> prices = new ArrayList<>();

    @JsonIgnore
    public ItemPriceDto findPriceByDateRange(Long dateRangeId, String currency) {
        for (ItemPriceDto price : prices) {
            if ( price.getDateRangeId().equals(dateRangeId) && price.getCurrency().equalsIgnoreCase(currency) ) {
                return price;
            }
        }

        ItemPriceDto price = new ItemPriceDto();
        price.amount = 0d;
        price.costItemId = id;
        price.currency = currency;
        price.dateRangeId = dateRangeId;
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CostItemTypeEnum getItemType() {
        return itemType;
    }

    public void setItemType(CostItemTypeEnum itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public List<ItemPriceDto> getPrices() {
        return prices;
    }

    public void setPrices(List<ItemPriceDto> prices) {
        this.prices = prices;
    }
}
