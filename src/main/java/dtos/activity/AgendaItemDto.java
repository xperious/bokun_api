package dtos.activity;

import com.codiform.moo.annotation.Property;

import dtos.PlaceDto;

public class AgendaItemDto {

    public Long id;
    public int index;
    public String title;
    public String body;

    @Property(translate = true)
    public PlaceDto place;
    
}
