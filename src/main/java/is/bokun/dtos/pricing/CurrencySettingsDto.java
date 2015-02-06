package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "CurrencySettings")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencySettingsDto {

    public String startDate;
    public String currency;
    public CurrencyHandlingTypeEnum currencyHandling;
    public Double conversionRate;
    public String parentCurrency;
    public RoundingSettingsEnum roundingSettings;
    public Integer roundingNumber;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CurrencyHandlingTypeEnum getCurrencyHandling() {
        return currencyHandling;
    }

    public void setCurrencyHandling(CurrencyHandlingTypeEnum currencyHandling) {
        this.currencyHandling = currencyHandling;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getParentCurrency() {
        return parentCurrency;
    }

    public void setParentCurrency(String parentCurrency) {
        this.parentCurrency = parentCurrency;
    }

    public RoundingSettingsEnum getRoundingSettings() {
        return roundingSettings;
    }

    public void setRoundingSettings(RoundingSettingsEnum roundingSettings) {
        this.roundingSettings = roundingSettings;
    }

    public Integer getRoundingNumber() {
        return roundingNumber;
    }

    public void setRoundingNumber(Integer roundingNumber) {
        this.roundingNumber = roundingNumber;
    }

    @Override
    public String toString() {
        return "CurrencySettingsDto{" +
                "startDate='" + startDate + '\'' +
                ", parentCurrency='" + parentCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", currencyHandling=" + currencyHandling +
                '}';
    }
}
