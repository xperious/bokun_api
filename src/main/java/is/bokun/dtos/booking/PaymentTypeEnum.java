package is.bokun.dtos.booking;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PaymentTypeEnum {

	WEB_PAYMENT, POINT_OF_SALE, CASH, VOUCHER;
}
