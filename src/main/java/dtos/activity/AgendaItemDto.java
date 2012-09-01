package dtos.activity;

import java.util.*;

import com.codiform.moo.annotation.Property;

import dtos.*;

public class AgendaItemDto {

    public Long id;
    public int index;
    public String title;
    public String body;

    @Property(translate = true)
    public PlaceDto place;
    
    public List<PhotoDto> photos = new ArrayList<PhotoDto>();
    
}
