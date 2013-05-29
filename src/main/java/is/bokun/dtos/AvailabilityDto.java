package is.bokun.dtos;

import java.util.Date;

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
	public boolean isUnlimitedAvailability() {
		return unlimitedAvailability;
	}
	public void setUnlimitedAvailability(boolean unlimitedAvailability) {
		this.unlimitedAvailability = unlimitedAvailability;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
    
    
}
