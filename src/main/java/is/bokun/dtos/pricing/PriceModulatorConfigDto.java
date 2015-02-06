package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.utils.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sindri Traustason
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PriceModulatorConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceModulatorConfigDto {
    public Long id;
    public String modulatorType;
    public boolean promotion;
    public Long priceCatalogId;
    public Map<String, String> values = new HashMap<>();
    public boolean alwaysOn;
    public Date startDate;
    public Date endDate;
    public boolean allMonths;
    public List<Integer> months;
    public boolean allWeekdays;
    public List<Integer> weekdays;


    public Long getId() {
        return id;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public String getModulatorType() {
        return modulatorType;
    }

    public Long getPriceCatalogId() {
        return priceCatalogId;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public boolean isAlwaysOn() {
        return alwaysOn;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isAllMonths() {
        return allMonths;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public boolean isAllWeekdays() {
        return allWeekdays;
    }

    public List<Integer> getWeekDays() {
        return weekdays;
    }

    public String getValue(String name, String defaultVal) {
        if (values.containsKey(name)) {
            return values.get(name);
        } else {
            return defaultVal;
        }
    }

    public String getValue(String name) {
        return getValue(name, null);
    }

    public double getDoubleValue(String name) {
        try {
            return Double.parseDouble(getValue(name));
        } catch (Throwable ignored) {
            return 0d;
        }
    }

    public long getLongValue(String name) {
        try {
            return Long.parseLong(getValue(name));
        } catch (Throwable ignored) {
            return 0L;
        }
    }

    public int getIntValue(String name) {
        return getIntValue(name, 0);
    }

    public int getIntValue(String name, int defaultVal) {
        try {
            return Integer.parseInt(getValue(name));
        } catch (Throwable ignored) {
            return defaultVal;
        }
    }

    public boolean getBoolValue(String name, boolean defaultVal) {
        try {
            String val = getValue(name);
            if ( !StringUtils.isNullOrEmpty(val) ) {
                return Boolean.parseBoolean(val);
            } else {
                return defaultVal;
            }
        } catch (Throwable ignored) {
            return defaultVal;
        }
    }
}
