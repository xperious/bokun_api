package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentDto {

    private Double amount;
    private String currency;
    private String paymentReferenceId;
    private PaymentTypeEnum paymentType;

}
