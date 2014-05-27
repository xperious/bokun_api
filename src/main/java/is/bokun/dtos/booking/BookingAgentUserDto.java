package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingAgentUserDto {

    public Long id;
    public String name;

    public BookingAgentUserDto(){}

    public BookingAgentUserDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
