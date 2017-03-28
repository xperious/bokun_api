package is.bokun.dtos.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import is.bokun.dtos.*;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIgnoreType()
@XmlType(name = "roomType")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomTypeDto extends HasBookableExtras implements WithPhotos {

	public Long id;
	public String externalId;
	public String title, description;
	
    public String accommodationType;
	
    public String spaceType;
	
	public int capacity = 1;
	
	public int minNightsStay = 1;
	public int maxNightsStay = 30;
	
	public int roomCount = 1;
	
	public int singleBedCount = 0;
	public int doubleBedCount = 0;
	public int sofaBedCount = 0;

	public boolean shared = false;

    public boolean internalUseOnly;
	
	public String pricingType;

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

	public String getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMinNightsStay() {
		return minNightsStay;
	}

	public void setMinNightsStay(int minNightsStay) {
		this.minNightsStay = minNightsStay;
	}

	public int getMaxNightsStay() {
		return maxNightsStay;
	}

	public void setMaxNightsStay(int maxNightsStay) {
		this.maxNightsStay = maxNightsStay;
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

	public String getPricingType() {
		return pricingType;
	}

	public void setPricingType(String pricingType) {
		this.pricingType = pricingType;
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
		public boolean stayRestriction;
		public int minNightsStay;
		public int maxNightsStay;
		public String cancellationPolicy;
	}

}
