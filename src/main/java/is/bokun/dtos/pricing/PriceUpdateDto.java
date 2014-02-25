package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceUpdateDto {

    public List<ItemPriceDto> itemPrices = new ArrayList<>();


    public List<ItemPriceDto> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPriceDto> itemPrices) {
        this.itemPrices = itemPrices;
    }
}
