package is.bokun.dtos.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ogg on 19/1/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ChargeTypeEnum {

    REMAINING_AMOUNT;

}
