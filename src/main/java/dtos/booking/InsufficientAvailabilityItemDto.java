package dtos.booking;

import java.util.Date;

public class InsufficientAvailabilityItemDto {

	public Long id;
	public String type;
	public String title;
	
	public Date startDate, endDate;
	
	public int availabilitiesRequired;
	public int availabilitiesLeft;
	
	public InsufficientAvailabilityItemDto() {}
	
	public InsufficientAvailabilityItemDto(Long id, String title, String type, int availabilitiesLeft, int availabilitiesRequired) {
		this(id, title, type, availabilitiesLeft, availabilitiesRequired, null, null);
	}
	
	public InsufficientAvailabilityItemDto(Long id, String title, String type, int availabilitiesLeft, int availabilitiesRequired, Date startDate, Date endDate) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.availabilitiesLeft = availabilitiesLeft;
		this.availabilitiesRequired = availabilitiesRequired;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
