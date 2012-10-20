package dtos.activity;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.codiform.moo.annotation.Property;

import dtos.PriceByMonthDto;

public class StartTimeDto {

	public Long id;
	
	public int hour = 12;
	public int minute;
	
    @Property(translation = "durationType.name()")
    public String durationType;
    public int duration = 1;
    
    @Property(translate = true)
    public PriceByMonthDto prices;
    
    public StartTimeDto() {}
    
    @JsonIgnore
    public int getLowestPrice() {
    	return prices.getLowestPrice();
    }
    
}
