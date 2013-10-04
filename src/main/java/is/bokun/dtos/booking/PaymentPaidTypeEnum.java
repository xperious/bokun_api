package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PaymentPaidTypeEnum {

	PAID_IN_FULL, DEPOSIT, FREE, NOT_PAID;
}
