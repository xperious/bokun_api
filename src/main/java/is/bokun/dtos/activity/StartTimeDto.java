package is.bokun.dtos.activity;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "startTime")
@XmlAccessorType(XmlAccessType.FIELD)
public class StartTimeDto {

	public Long id;
	
	public int hour = 12;
	public int minute;

    public boolean overrideTimeWhenPickup;
    public int pickupHour;
    public int pickupMinute;

    /**
     * @deprecated use duration minutes, hours, days and weeks
     */
    @Deprecated
    public String durationType;
    /**
     * @deprecated use duration minutes, hours, days and weeks
     */
    @Deprecated
    public int duration = 1;

    public int durationMinutes = 0;
    public int durationHours = 1;
    public int durationDays = 0;
    public int durationWeeks = 0;

    public List<String> flags = new ArrayList<>();
    
    public StartTimeDto() {}
    
    @JsonIgnore
    public String getTimeAsString() {
        StringBuilder s = new StringBuilder();
        if ( hour < 10 ) {
            s.append(0);
        }
        s.append(hour);
        s.append(':');
        if ( minute < 10 ) {
            s.append(0);
        }
        s.append(minute);
        return s.toString();
    }

    @JsonIgnore
    public String getPickupTimeAsString() {
        if ( !overrideTimeWhenPickup ) {
            return getTimeAsString();
        }
        StringBuilder s = new StringBuilder();
        if ( pickupHour < 10 ) {
            s.append(0);
        }
        s.append(pickupHour);
        s.append(':');
        if ( pickupMinute < 10 ) {
            s.append(0);
        }
        s.append(pickupMinute);
        return s.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isOverrideTimeWhenPickup() {
        return overrideTimeWhenPickup;
    }

    public void setOverrideTimeWhenPickup(boolean overrideTimeWhenPickup) {
        this.overrideTimeWhenPickup = overrideTimeWhenPickup;
    }

    public int getPickupHour() {
        return pickupHour;
    }

    public void setPickupHour(int pickupHour) {
        this.pickupHour = pickupHour;
    }

    public int getPickupMinute() {
        return pickupMinute;
    }

    public void setPickupMinute(int pickupMinute) {
        this.pickupMinute = pickupMinute;
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

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
