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

}
