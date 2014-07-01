package is.bokun.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "availability")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityDto {

    public String id;

    public Date dayOfMonth;

    public int availabilityCount;
    public boolean unlimitedAvailability;
    public boolean closed;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(Date dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public int getAvailabilityCount() {
		return availabilityCount;
	}
	public void setAvailabilityCount(int availabilityCount) {
		this.availabilityCount = availabilityCount;
	}

	public void setUnlimitedAvailability(boolean unlimitedAvailability) {
		this.unlimitedAvailability = unlimitedAvailability;
	}
    
    
}
