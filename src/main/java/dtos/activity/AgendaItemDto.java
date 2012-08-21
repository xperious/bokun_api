package dtos.activity;

import java.util.Set;

import com.codiform.moo.annotation.*;

import dtos.PlaceDto;

public class AgendaItemDto {

    public Long id;
    public int index;
    public String title;
    public String body;

    @Property(translate = true)
    public PlaceDto place;
    
	@CollectionProperty(translation = "photos()")
	public Set<Long> photoIds;
    
}
