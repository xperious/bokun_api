package is.bokun.dtos.accommodation;

import is.bokun.dtos.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "roomType")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomTypeDto extends HasBookableExtras implements WithPhotos {

	public Long id;
	public String externalId;
	public String title;
	public String description;
	
	public int capacity = 1;
	
	public int roomCount = 1;
	
	public int singleBedCount = 0;
	public int doubleBedCount = 0;
	public int sofaBedCount = 0;

	public boolean shared = false;

    public boolean internalUseOnly;

    @XmlElementWrapper
    @XmlElement(name="tag")
	public List<TagGroupDto> tags = new ArrayList<>();
	
	public PhotoDto keyPhoto;

    @XmlElementWrapper
    @XmlElement(name="photo")
	public List<PhotoDto> photos = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="flag")
	public List<String> flags = new ArrayList<>();

    public List<RoomRate> roomRates = new ArrayList<>();
	
	@Override
	public void addPhoto(PhotoDto p) {
		photos.add(p);
	}
	@Override
	public List<PhotoDto> getPhotos() {
		return photos;
	}
	@Override
	public void setPhotos(List<PhotoDto> photos) {
		this.photos = photos;
	}
	@Override
	public void setKeyPhoto(PhotoDto p) {
		keyPhoto = p;
	}
	@Override
	public PhotoDto getKeyPhoto() {
		return keyPhoto;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public int getSingleBedCount() {
		return singleBedCount;
	}

	public void setSingleBedCount(int singleBedCount) {
		this.singleBedCount = singleBedCount;
	}

	public int getDoubleBedCount() {
		return doubleBedCount;
	}

	public void setDoubleBedCount(int doubleBedCount) {
		this.doubleBedCount = doubleBedCount;
	}

	public int getSofaBedCount() {
		return sofaBedCount;
	}

	public void setSofaBedCount(int sofaBedCount) {
		this.sofaBedCount = sofaBedCount;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public boolean isInternalUseOnly() {
		return internalUseOnly;
	}

	public void setInternalUseOnly(boolean internalUseOnly) {
		this.internalUseOnly = internalUseOnly;
	}

	public List<TagGroupDto> getTags() {
		return tags;
	}

	public void setTags(List<TagGroupDto> tags) {
		this.tags = tags;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

    @JsonIgnoreProperties(ignoreUnknown = true)
	public static class RoomRate {
		public long id;
		public String title;
		public int maxOccupants;
		public boolean stayRestrictions;
		public int minNightsStay;
		public int maxNightsStay;
		public CancellationPolicyDto cancellationPolicy;
	}

}
