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

    public boolean pickupAllotment;
    public boolean useComponentPickupAllotments;
    public List<String> pickupFlags = new ArrayList<>();
    public boolean customPickupAllowed;
    public Integer pickupMinutesBefore;
    public String noPickupMsg;
    public boolean showGlobalPickupMsg;
    public boolean showNoPickupMsg;
    
    public boolean dropoffService;
    public List<String> dropoffFlags = new ArrayList<>();
    public boolean customDropoffAllowed;

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

    public LocationCodeDto locationCode;

	public int bookingCutoffDays;

	public int bookingCutoffHours;

	public int bookingCutoffMinutes;

	public int bookingCutoffWeeks;

	public List<ActivityStartPoint> startPoints = new ArrayList<>();

	public List<ActivityRateDto> rates = new ArrayList<>();

	public int defaultRateId;

	public MeetingTypeEnum meetingType;

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

	public String getIncluded() {
		return included;
	}

	public void setIncluded(String included) {
		this.included = included;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public Long getBoxedActivityId() {
		return boxedActivityId;
	}

	public void setBoxedActivityId(Long boxedActivityId) {
		this.boxedActivityId = boxedActivityId;
	}

	public boolean isComboActivity() {
		return comboActivity;
	}

	public void setComboActivity(boolean comboActivity) {
		this.comboActivity = comboActivity;
	}

	public boolean isDayBasedAvailability() {
		return dayBasedAvailability;
	}

	public void setDayBasedAvailability(boolean dayBasedAvailability) {
		this.dayBasedAvailability = dayBasedAvailability;
	}

	public boolean isSelectFromDayOptions() {
		return selectFromDayOptions;
	}

	public void setSelectFromDayOptions(boolean selectFromDayOptions) {
		this.selectFromDayOptions = selectFromDayOptions;
	}

	public List<String> getDayOptions() {
		return dayOptions;
	}

	public void setDayOptions(List<String> dayOptions) {
		this.dayOptions = dayOptions;
	}

	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public int getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public int getDurationWeeks() {
		return durationWeeks;
	}

	public void setDurationWeeks(int durationWeeks) {
		this.durationWeeks = durationWeeks;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public Double getNextDefaultPrice() {
		return nextDefaultPrice;
	}

	public void setNextDefaultPrice(Double nextDefaultPrice) {
		this.nextDefaultPrice = nextDefaultPrice;
	}

	public boolean isPickupAllotment() {
		return pickupAllotment;
	}

	public void setPickupAllotment(boolean pickupAllotment) {
		this.pickupAllotment = pickupAllotment;
	}

	public boolean isUseComponentPickupAllotments() {
		return useComponentPickupAllotments;
	}

	public void setUseComponentPickupAllotments(boolean useComponentPickupAllotments) {
		this.useComponentPickupAllotments = useComponentPickupAllotments;
	}

	public List<String> getPickupFlags() {
		return pickupFlags;
	}

	public void setPickupFlags(List<String> pickupFlags) {
		this.pickupFlags = pickupFlags;
	}

	public boolean isCustomPickupAllowed() {
		return customPickupAllowed;
	}

	public void setCustomPickupAllowed(boolean customPickupAllowed) {
		this.customPickupAllowed = customPickupAllowed;
	}

	public Integer getPickupMinutesBefore() {
		return pickupMinutesBefore;
	}

	public void setPickupMinutesBefore(Integer pickupMinutesBefore) {
		this.pickupMinutesBefore = pickupMinutesBefore;
	}

	public String getNoPickupMsg() {
		return noPickupMsg;
	}

	public void setNoPickupMsg(String noPickupMsg) {
		this.noPickupMsg = noPickupMsg;
	}

	public boolean isShowGlobalPickupMsg() {
		return showGlobalPickupMsg;
	}

	public void setShowGlobalPickupMsg(boolean showGlobalPickupMsg) {
		this.showGlobalPickupMsg = showGlobalPickupMsg;
	}

	public boolean isShowNoPickupMsg() {
		return showNoPickupMsg;
	}

	public void setShowNoPickupMsg(boolean showNoPickupMsg) {
		this.showNoPickupMsg = showNoPickupMsg;
	}

	public boolean isDropoffService() {
		return dropoffService;
	}

	public void setDropoffService(boolean dropoffService) {
		this.dropoffService = dropoffService;
	}

	public List<String> getDropoffFlags() {
		return dropoffFlags;
	}

	public void setDropoffFlags(List<String> dropoffFlags) {
		this.dropoffFlags = dropoffFlags;
	}

	public boolean isCustomDropoffAllowed() {
		return customDropoffAllowed;
	}

	public void setCustomDropoffAllowed(boolean customDropoffAllowed) {
		this.customDropoffAllowed = customDropoffAllowed;
	}

	public boolean isSeasonAllYear() {
		return seasonAllYear;
	}

	public void setSeasonAllYear(boolean seasonAllYear) {
		this.seasonAllYear = seasonAllYear;
	}

	public int getSeasonStartDate() {
		return seasonStartDate;
	}

	public void setSeasonStartDate(int seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	public int getSeasonStartMonth() {
		return seasonStartMonth;
	}

	public void setSeasonStartMonth(int seasonStartMonth) {
		this.seasonStartMonth = seasonStartMonth;
	}

	public int getSeasonEndDate() {
		return seasonEndDate;
	}

	public void setSeasonEndDate(int seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
	}

	public int getSeasonEndMonth() {
		return seasonEndMonth;
	}

	public void setSeasonEndMonth(int seasonEndMonth) {
		this.seasonEndMonth = seasonEndMonth;
	}

	public List<WeekdayDto> getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(List<WeekdayDto> weekdays) {
		this.weekdays = weekdays;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public List<PricingCategoryDto> getPricingCategories() {
		return pricingCategories;
	}

	public void setPricingCategories(List<PricingCategoryDto> pricingCategories) {
		this.pricingCategories = pricingCategories;
	}

	public List<AgendaItemDto> getAgendaItems() {
		return agendaItems;
	}

	public void setAgendaItems(List<AgendaItemDto> agendaItems) {
		this.agendaItems = agendaItems;
	}

	public List<StartTimeDto> getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(List<StartTimeDto> startTimes) {
		this.startTimes = startTimes;
	}

	public List<BookableExtraDto> getBookableExtras() {
		return bookableExtras;
	}

	public void setBookableExtras(List<BookableExtraDto> bookableExtras) {
		this.bookableExtras = bookableExtras;
	}

	public ActivityRouteDto getRoute() {
		return route;
	}

	public void setRoute(ActivityRouteDto route) {
		this.route = route;
	}

	public List<ActivityRateDto> getRates() { return rates; }

	public void setRates(List<ActivityRateDto> rates) { this.rates = rates; }

	public int getDefaultRateId() { return defaultRateId; }

	public void setDefaultRateId(int defaultRateId) { this.defaultRateId = defaultRateId; }

	public MeetingTypeEnum getMeetingType() { return meetingType; }

	public void setMeetingType(MeetingTypeEnum meetingType) { this.meetingType = meetingType; }
}
