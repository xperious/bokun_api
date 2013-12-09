package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerServiceBookingDto {

    public Long id;
    public Long partnerId;
    public Long serviceId;
    public PartnerServiceBookingStatusEnum status;
    public Date replyDate;

    public boolean unreadComments;

    public String serviceTitle;
    public Double price;
    public PartnerServicePricingTypeEnum pricingType;

}
