package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDto {

    public Long id;

    public String title;

    public LocationDto location;
}
