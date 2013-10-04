package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PaymentTypeEnum {

	WEB_PAYMENT, POINT_OF_SALE, CASH, VOUCHER;
}
