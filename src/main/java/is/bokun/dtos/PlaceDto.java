package is.bokun.dtos;

import com.codiform.moo.annotation.Property;

public class PlaceDto {

    public Long id;

    public String title;

    @Property(translate = true)
    public LocationDto location;
}
