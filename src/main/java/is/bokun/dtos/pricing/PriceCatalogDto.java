package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.ItemDto;
import is.bokun.utils.PriceUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.xml.bind.annotation.*;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "priceCatalog")
@XmlType(name = "PriceCatalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceCatalogDto {

    public Long id;
    public String title;
    public Long ownerId;
    public Long defaultSheetId;
    public String defaultCurrency;

    @XmlElement(name="currency")
    public List<String> currencies = new ArrayList<>();

    @XmlElement(name="currencySettings")
    public List<CurrencySettingsDto> currencySettings = new ArrayList<>();

    @XmlElement(name="sheet")
    public List<PriceSheetDto> sheets = new ArrayList<>();
    public Map<String, PriceConversionDto> conversions = new HashMap<>();
    public String supplierCurrency;
    public List<String> parentCurrencies = new ArrayList<>();
    public boolean convertUsingBookingDate;

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

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    public List<CurrencySettingsDto> getCurrencySettings() {
        return currencySettings;
    }

    public void setCurrencySettings(List<CurrencySettingsDto> currencySettings) {
        this.currencySettings = currencySettings;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Map<String, PriceConversionDto> getConversions() {
        return conversions;
    }

    public void setConversions(Map<String, PriceConversionDto> conversions) {
        this.conversions = conversions;
    }

    public boolean hasCostGroup(Long costGroupId) {
        for (PriceSheetDto sheet : sheets) {
            if ( sheet.findCostGroupById(costGroupId) != null ) {
                return true;
            }
        }
        return false;
    }

    public static ItemPriceDto findFirstExistingPreviousPrice(PriceSheetDateRangeDto current, List<PriceSheetDateRangeDto> dateRanges, CostItemDto item, String currency, int index) {
        ItemPriceDto price = null;
        int a = index-1;
        while ( a >= 0 ) {
            PriceSheetDateRangeDto prev = dateRanges.get(a);
            price = item.findPriceByDateRange(prev.id, currency);
            if ( price != null ) {
                return price;
            }
            a--;
        }
        return null;
        /*
        price = new ItemPriceDto();
        price.amount = 0d;
        price.costItemId = item.id;
        price.currency = currency;
        price.dateRangeId = current.getId();
        return price;
        */
    }

    public static CellPriceDto findFirstExistingPreviousPrice(PriceSheetDateRangeDto current, List<PriceSheetDateRangeDto> dateRanges, CostMatrixCellDto cell, String currency, int index) {
        CellPriceDto price = null;
        int a = index-1;
        while ( a >= 0 ) {
            PriceSheetDateRangeDto prev = dateRanges.get(a);
            price = cell.findPriceByDateRange(prev.id, currency);
            if ( price != null ) {
                return price;
            }
            a--;
        }
        return null;
        /*
        price = new CellPriceDto();
        price.amount = null;
        price.cellId = cell.id;
        price.currency = currency;
        price.dateRangeId = current.getId();
        return price;*/
    }

    @JsonIgnore
    public CostMatrixDto findMatrix(CostGroupTypeEnum groupType, Long groupParentId, Long matrixId1, Long matrixId2, Long matrixId3, Date date) {

        for (PriceSheetDto sheet : getSheets()) {
            CostGroupDto grp = sheet.findCostGroup(groupType, groupParentId);
            if (grp != null) {
                DateTime dateTime = new DateTime(date);
                List<PriceSheetDateRangeDto> dateRanges = sheet.getDateRanges();
                for (int i = 0; i < dateRanges.size(); i++) {
                    PriceSheetDateRangeDto current = dateRanges.get(i);
                    PriceSheetDateRangeDto next = null;
                    if (i < dateRanges.size() - 1) {
                        next = dateRanges.get(i + 1);
                    }

                    boolean isEqualOrAfterThisRange = dateTime.isEqual(current.getStart().getTime()) || dateTime.isAfter(current.getStart().getTime());
                    if (isEqualOrAfterThisRange && (next == null || dateTime.isBefore(next.getStart().getTime()))) {

                        CostMatrixDto costMatrix = grp.findCostMatrix(matrixId1, matrixId2, matrixId3);
                        return costMatrix;
                    }
                }
            }
        }
        return null;
    }


    @JsonIgnore
    public CellPriceDto findMatrixPrice(CostGroupTypeEnum groupType, Long groupParentId, Long matrixId1, Long matrixId2, Long matrixId3,
                                        Long axisFromItemId, Long axisToItemId, String currency, Date date) {

        for (PriceSheetDto sheet : getSheets()) {
            CostGroupDto grp = sheet.findCostGroup(groupType, groupParentId);
            if (grp != null) {
                DateTime dateTime = new DateTime(date);
                List<PriceSheetDateRangeDto> dateRanges = sheet.getDateRanges();
                for (int i = 0; i < dateRanges.size(); i++) {
                    PriceSheetDateRangeDto current = dateRanges.get(i);
                    PriceSheetDateRangeDto next = null;
                    if (i < dateRanges.size() - 1) {
                        next = dateRanges.get(i + 1);
                    }

                    boolean isEqualOrAfterThisRange = dateTime.isEqual(current.getStart().getTime()) || dateTime.isAfter(current.getStart().getTime());
                    if (isEqualOrAfterThisRange && (next == null || dateTime.isBefore(next.getStart().getTime()))) {

                        CostMatrixDto costMatrix = grp.findCostMatrix(matrixId1, matrixId2, matrixId3);
                        if ( costMatrix != null ) {
                            CostMatrixDto masterMatrix = null;
                            if ( costMatrix.getDependent() ) {
                                masterMatrix = grp.findCostMatrixById(costMatrix.masterId);
                            }

                            CellPriceDto cellPrice = findCellPrice(costMatrix, current, dateRanges, axisFromItemId, axisToItemId, currency, i);
                            if ( masterMatrix != null ) {
                                if ( cellPrice != null ) {
                                    cellPrice = cellPrice.clone(); // so we don't change the original object in the catalog
                                } else {
                                    CostMatrixCellDto costCell = costMatrix.findCell(axisFromItemId, axisToItemId);
                                    cellPrice = new CellPriceDto();
                                    cellPrice.amount = null;
                                    cellPrice.cellId = costCell != null ? costCell.id : 0;
                                    cellPrice.currency = currency;
                                    cellPrice.dateRangeId = current.id;
                                }

                                // price is calculated from another matrix
                                CellPriceDto masterCellPrice = findCellPrice(masterMatrix, current, dateRanges, axisFromItemId, axisToItemId, currency, i);
                                if ( masterCellPrice != null ) {
                                    // apply price change
                                    Double amount = masterCellPrice.amount;
                                    if ( costMatrix.priceChangeType != null ) {
                                        switch (costMatrix.priceChangeType) {
                                            case AMOUNT:
                                                if ( costMatrix.amount != null ) {
                                                    amount += costMatrix.amount;
                                                }
                                                break;
                                            case PERCENTAGE:
                                                if ( costMatrix.amount != null ) {
                                                    double perc = costMatrix.amount;
                                                    if (perc > 0) {
                                                        amount += PriceUtils.percentage(amount, perc);
                                                    } else if (perc < 0) {
                                                        amount -= PriceUtils.percentage(amount, -1d*perc);
                                                    }
                                                    if (amount < 0) {
                                                        amount = 0d;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    cellPrice.amount = amount;
                                    return cellPrice;
                                }

                            } else {
                                if ( cellPrice != null ) {
                                    return cellPrice;
                                }
                            }
                        }
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private CellPriceDto findCellPrice(CostMatrixDto costMatrix, PriceSheetDateRangeDto current, List<PriceSheetDateRangeDto> dateRanges, Long axisFromItemId, Long axisToItemId, String currency, int i) {
        CostMatrixCellDto costCell = costMatrix.findCell(axisFromItemId, axisToItemId);
        if (costCell != null) {
            CellPriceDto cellPrice = costCell.findPriceByDateRange(current.id, currency);
            if (cellPrice != null) {
                return cellPrice;
            } else {
                // try to get price from earlier date range
                return findFirstExistingPreviousPrice(current, dateRanges, costCell, currency, i);
            }
        } else {
            return null;
        }
    }

    @JsonIgnore
    public ItemPriceDto findPrice(CostGroupTypeEnum groupType, Long groupParentId, CostItemTypeEnum itemType, String itemId, String currency, Date date) {
        for (PriceSheetDto sheet : getSheets()) {
            CostGroupDto grp = sheet.findCostGroup(groupType, groupParentId);
            if ( grp != null ) {
                DateTime dateTime = new DateTime(date);
                List<PriceSheetDateRangeDto> dateRanges = sheet.getDateRanges();
                for (int i = 0; i < dateRanges.size(); i++) {
                    PriceSheetDateRangeDto current = dateRanges.get(i);
                    PriceSheetDateRangeDto next = null;
                    if (i < dateRanges.size() - 1) {
                        next = dateRanges.get(i + 1);
                    }

                    boolean isEqualOrAfterThisRange = dateTime.isEqual(current.getStart().getTime()) || dateTime.isAfter(current.getStart().getTime());
                    if ( isEqualOrAfterThisRange && (next == null || dateTime.isBefore(next.getStart().getTime())) ) {
                        CostItemDto item = grp.findCostItem(itemType, itemId);
                        if ( item != null ) {
                            ItemPriceDto itemPrice = item.findPriceByDateRange(current.id, currency);
                            if ( itemPrice != null ) {
                                return itemPrice;
                            } else {
                                // try to get price from earlier date range
                                return findFirstExistingPreviousPrice(current, dateRanges, item, currency, i);
                            }
                        }
                        return null;
                    }
                }


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
    public CostItemDto findItem(CostGroupTypeEnum groupType, Long groupParentId, CostItemTypeEnum itemType, String itemId, Date date) {
        for (PriceSheetDto sheet : getSheets()) {
            CostGroupDto grp = sheet.findCostGroup(groupType, groupParentId);
            if ( grp != null ) {
                DateTime dateTime = new DateTime(date);
                List<PriceSheetDateRangeDto> dateRanges = sheet.getDateRanges();
                for (int i = 0; i < dateRanges.size(); i++) {
                    PriceSheetDateRangeDto current = dateRanges.get(i);
                    PriceSheetDateRangeDto next = null;
                    if (i < dateRanges.size() - 1) {
                        next = dateRanges.get(i + 1);
                    }

                    boolean isEqualOrAfterThisRange = dateTime.isEqual(current.getStart().getTime()) || dateTime.isAfter(current.getStart().getTime());
                    if ( isEqualOrAfterThisRange && (next == null || dateTime.isBefore(next.getStart().getTime())) ) {
                        CostItemDto item = grp.findCostItem(itemType, itemId);
                        return item;
                    }
                }


                PriceSheetDateRangeDto dateRange = sheet.findDateRange(date);
                if ( dateRange != null ) {
                    CostItemDto item = grp.findCostItem(itemType, itemId);
                    return item;
                }
                return null;
            }
        }
        return null;
    }

    public CurrencySettingsDto findCurrencySetting(LocalDate date, String fromCurrency, String toCurrency) {
        for(CurrencySettingsDto dto: currencySettings){
            if(LocalDate.parse(dto.startDate).compareTo(date) <= 0 && toCurrency.equals(dto.currency) && fromCurrency.equals(dto.parentCurrency)){
                return dto;
            }
        }
        return null;
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
