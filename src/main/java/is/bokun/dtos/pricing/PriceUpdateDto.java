package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceUpdateDto {

    public List<ItemPriceDto> itemPrices = new ArrayList<>();
    public List<CellPriceDto> cellPrices = new ArrayList<>();
    public List<CostMatrixDto> changedMatrices = new ArrayList<>();


    public List<ItemPriceDto> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPriceDto> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public List<CellPriceDto> getCellPrices() {
        return cellPrices;
    }

    public void setCellPrices(List<CellPriceDto> cellPrices) {
        this.cellPrices = cellPrices;
    }

    public List<CostMatrixDto> getChangedMatrices() {
        return changedMatrices;
    }

    public void setChangedMatrices(List<CostMatrixDto> changedMatrices) {
        this.changedMatrices = changedMatrices;
    }
}
