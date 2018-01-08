package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PricingTypeEnum {

    INCLUDED_IN_PRICE,
    PRICED_SEPARATELY

}
