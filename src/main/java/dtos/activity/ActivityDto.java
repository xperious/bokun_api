package dtos.activity;

import java.util.*;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import dtos.ProductDto;

public class ActivityDto extends ProductDto {

    public String included;
    public String requirements; 
    public String attention;
    
    @Property(translation = "durationType.name()")
    public String durationType;
    public int duration;

    @Property(translation = "pricingType.name()")
    public String pricingType;
    
    public int minAge;
    public int maxChildrenPerAdult = 4;

    public int childMaxAge = 11;
    public int teenagerMaxAge = 17;

    public boolean seasonAllYear;

    public int seasonStartDate;
    public int seasonStartMonth;

    public int seasonEndDate;
    public int seasonEndMonth;
    
    @Property(translation = "difficultyLevel.name()")
    public String difficultyLevel;
    
    @CollectionProperty(itemTranslation = AgendaItemDto.class)
    public List<AgendaItemDto> agendaItems = new ArrayList<AgendaItemDto>();

    @CollectionProperty(itemTranslation = StartTimeDto.class)
    public List<StartTimeDto> startTimes = new ArrayList<StartTimeDto>();

    @CollectionProperty(itemTranslation = ActivityExtraDto.class)
    public List<ActivityExtraDto> bookableExtras = new ArrayList<ActivityExtraDto>();
	
	public ActivityDto() {
		super();
	}
}
