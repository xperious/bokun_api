package is.bokun.dtos.activity;

import is.bokun.dtos.*;
import is.bokun.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "activity")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivityDto extends ProductDto implements WithExtras {

    public String included;
    public String requirements; 
    public String attention;

    public Long boxedActivityId;

    public boolean comboActivity;

    public boolean dayBasedAvailability;
    public boolean selectFromDayOptions;
    public List<String> dayOptions = new ArrayList<>();

    /**
     * @deprecated use duration minutes, hours, days and weeks
     */
    @Deprecated()
    public String durationType;
    /**
     * @deprecated use duration minutes, hours, days and weeks
     */
    @Deprecated()
    public int duration;

    public int durationMinutes;
    public int durationHours;
    public int durationDays;
    public int durationWeeks;

    public int minAge;
    
    public Double nextDefaultPrice;
    
    public boolean pickupService;
    public boolean pickupAllotment;
    public boolean useComponentPickupAllotments;
    public List<String> pickupFlags = new ArrayList<>();
    public PickupPricingTypeEnum pickupPricingType;
    public Integer pickupMinutesBefore;
    public String noPickupMsg;
    public boolean showGlobalPickupMsg;
    public boolean showNoPickupMsg;
    
    public boolean dropoffService;
    public List<String> dropoffFlags = new ArrayList<>();
    public PickupPricingTypeEnum dropoffPricingType;

    public boolean seasonAllYear;

    public int seasonStartDate;
    public int seasonStartMonth;

    public int seasonEndDate;
    public int seasonEndMonth;
    
    public List<WeekdayDto> weekdays = new ArrayList<>();
    
    public String difficultyLevel;
    
    public List<PricingCategoryDto> pricingCategories = new ArrayList<>();
    
    public List<AgendaItemDto> agendaItems = new ArrayList<>();

    public List<StartTimeDto> startTimes = new ArrayList<>();

    public List<BookableExtraDto> bookableExtras = new ArrayList<>();
    
    public ActivityRouteDto route;
	
	public ActivityDto() {
		super();
	}
	
	@JsonIgnore
	public StartTimeDto findStartTime(Long id) {
		for (StartTimeDto dto : startTimes) {
			if ( dto.id.equals(id) ) {
				return dto;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public BookableExtraDto findExtra(Long id) {
		for (BookableExtraDto dto : bookableExtras) {
			if ( dto.id.equals(id) ) {
				return dto;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public PricingCategoryDto findPricingCategory(Long id) {
		for (PricingCategoryDto pcat : pricingCategories) {
			if ( pcat.id.equals(id) ) {
				return pcat;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public List<PricingCategoryDto> getPublicPricingCategories() {
		List<PricingCategoryDto> list = new ArrayList<>();
		for (PricingCategoryDto pcat : pricingCategories) {
			if ( !pcat.internalUseOnly ) {
				list.add(pcat);
			}
		}
		return list;
	}
	
	@JsonIgnore
	public boolean hasAnyMapLocation() {
		return countMapLocations() > 0;
	}
	
	@JsonIgnore
	public int countMapLocations() {
		int count = 0;
		for (AgendaItemDto item : agendaItems) {
			if ( item.place != null ) {
				count++;
			}
		}
		return count;
	}
	
	@JsonIgnore
	public String[] includedPoints() {
		return toPoints(included);
	}
	
	@JsonIgnore
	public String[] requirementsPoints() {
		return toPoints(requirements);
	}
	
	@JsonIgnore
	public String[] attentionPoints() {
		return toPoints(attention);
	}
	
	@JsonIgnore
	private String[] toPoints(String s) {
		if ( StringUtils.isNullOrEmpty(s) ) {
			return new String[0];
		}
		return s.split("\n");
	}
	
	@JsonIgnore
	public Date getSeasonStart() throws Exception {
		SimpleDateFormat parser = new SimpleDateFormat("dd.MM");
		return parser.parse("" + seasonStartDate + "." + seasonStartMonth);
	}
	
	@JsonIgnore
	public Date getSeasonEnd() throws Exception {
		SimpleDateFormat parser = new SimpleDateFormat("dd.MM");
		return parser.parse("" + seasonEndDate + "." + seasonEndMonth);
	}

    @JsonIgnore
    public List<BookableExtraDto> getIncludedExtras() {
        List<BookableExtraDto> list = new ArrayList<>();
        for ( BookableExtraDto e : bookableExtras ) {
            if ( e.included ) {
                list.add(e);
            }
        }
        return list;
    }

    @JsonIgnore
    public List<BookableExtraDto> getOptionalExtras() {
        List<BookableExtraDto> list = new ArrayList<>();
        for ( BookableExtraDto e : bookableExtras ) {
            if ( !e.included ) {
                list.add(e);
            }
        }
        return list;
    }

}
