package is.bokun.dtos;

import java.util.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "PickupPlace")
@XmlAccessorType(XmlAccessType.FIELD)
public class PickupPlaceDto {

	public Long id;
	public String title;
	public Boolean askForRoomNumber;
	
	public String externalId;
	
	public LocationDto location = new LocationDto();
	
	@XmlElementWrapper
	@XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocationDto getLocation() {
		return location;
	}

	public void setLocation(LocationDto location) {
		this.location = location;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public Boolean getAskForRoomNumber() {
		return askForRoomNumber;
	}

	public void setAskForRoomNumber(Boolean askForRoomNumber) {
		this.askForRoomNumber = askForRoomNumber;
	}
	
	
}
