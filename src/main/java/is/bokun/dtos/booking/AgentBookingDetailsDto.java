package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentBookingDetailsDto {

    public Long id;
    public String title;
    public Long contractId;
    public String contractType;
}
