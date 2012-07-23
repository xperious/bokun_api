package dtos.activity;

import java.util.List;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import dtos.ProductDto;

public class ActivityDto extends ProductDto {

    public String included;
    public String requirements; 
    public String attention;
    
    @Property(translation = "durationType.name()")
    public String durationType;

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
    public List<AgendaItemDto> agendaItems;

    @CollectionProperty(itemTranslation = StartTimeDto.class)
    public List<StartTimeDto> startTimes;

    @CollectionProperty(itemTranslation = ActivityExtraDto.class)
    public List<ActivityExtraDto> extras;
	
	public ActivityDto() {
		super();
	}
}
