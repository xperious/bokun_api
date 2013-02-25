package is.bokun.dtos.activity;

import java.util.*;

import com.codiform.moo.annotation.Property;

import is.bokun.dtos.*;

public class AgendaItemDto {

    public Long id;
    public int index;
    public String title;
    public String body;
    public boolean possibleStartPoint;
    public List<String> flags = new ArrayList<>();

    @Property(translate = true)
    public PlaceDto place;
    
    public List<PhotoDto> photos = new ArrayList<>();
    
}
