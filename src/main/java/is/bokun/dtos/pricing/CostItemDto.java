package is.bokun.dtos.pricing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 21/2/14.
 */
public class CostItemDto {

    public Long id;
    public String title;
    public CostItemTypeEnum itemType;
    public Long itemId;

    public List<ItemPriceDto> prices = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public List<ItemPriceDto> getPrices() {
        return prices;
    }

    public void setPrices(List<ItemPriceDto> prices) {
        this.prices = prices;
    }
}
