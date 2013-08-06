package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PaymentPaidTypeEnum {

	PAID_IN_FULL, DEPOSIT, FREE, NOT_PAID;
}
