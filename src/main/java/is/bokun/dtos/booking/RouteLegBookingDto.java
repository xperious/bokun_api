package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.PricingCategoryDto;
import is.bokun.dtos.transport.FareClassDto;
import is.bokun.dtos.transport.RouteLegDto;
import is.bokun.dtos.transport.RouteScheduleDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by ogg on 24.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteLegBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteLegBookingDto {

    public Long id;
    public Date date;

    public RouteLegDto leg;
    public RouteScheduleDto departure;

    public PricingCategoryDto pricingCategory;
    public FareClassDto fareClass;
    public boolean peak;
}
