package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceCatalogDto {

    public Long id;
    public String title;
    public Long defaultSheetId;
    public String defaultCurrency;

    public List<CurrencySettingsDto> currencies = new ArrayList<>();
    public List<PriceSheetDto> sheets = new ArrayList<>();

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

    public Long getDefaultSheetId() {
        return defaultSheetId;
    }

    public void setDefaultSheetId(Long defaultSheetId) {
        this.defaultSheetId = defaultSheetId;
    }

    public List<PriceSheetDto> getSheets() {
        return sheets;
    }

    public void setSheets(List<PriceSheetDto> sheets) {
        this.sheets = sheets;
    }

    public List<CurrencySettingsDto> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencySettingsDto> currencies) {
        this.currencies = currencies;
    }

    @JsonIgnore
    public ItemPriceDto findPrice(CostGroupTypeEnum groupType, Long groupParentId, CostItemTypeEnum itemType, String itemId, String currency, Date date) {
        for (PriceSheetDto sheet : getSheets()) {
            CostGroupDto grp = sheet.findCostGroup(groupType, groupParentId);
            if ( grp != null ) {
                PriceSheetDateRangeDto dateRange = sheet.findDateRange(date);
                if ( dateRange != null ) {
                    CostItemDto item = grp.findCostItem(itemType, itemId);
                    if ( item != null ) {
                        return item.findPriceByDateRange(dateRange.id, currency);
                    }
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    @JsonIgnore
    public List<CurrencySettingsDto> getDerivedCurrencies() {
        List<CurrencySettingsDto> list = new ArrayList<>();
        for (CurrencySettingsDto cs : getCurrencies()) {
            if (cs.getCurrencyHandling() != CurrencyHandlingTypeEnum.SPECIFY_AMOUNTS) {
                list.add(cs);
            }
        }
        return list;
    }

    @JsonIgnore
    public List<CurrencySettingsDto> getSpecifiedCurrencies() {
        List<CurrencySettingsDto> list = new ArrayList<>();
        for (CurrencySettingsDto cs : getCurrencies()) {
            if (cs.getCurrencyHandling() == CurrencyHandlingTypeEnum.SPECIFY_AMOUNTS) {
                list.add(cs);
            }
        }
        return list;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    @JsonIgnore
    public PriceSheetDto findSheet(Long id) {
        for (PriceSheetDto s : sheets) {
            if ( s.id.equals(id) ) {
                return s;
            }
        }
        return null;
    }
}