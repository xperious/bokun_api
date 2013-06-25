package is.bokun.dtos.carrental;

import is.bokun.dtos.*;
import is.bokun.dtos.search.SearchResult;
import is.bokun.queries.CarQuery;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

public class CarTypeDto extends HasBookableExtras implements SearchResult, WithPhotos {

	public Long id;
	public String title;
	public String description;
	public String exampleCarModel;
	
	public ItemDto vendor;
	public ItemDto carRental;
	
	public Integer rentalPrice;
	public Integer avgRentalPricePerDay;
	
	public int passengerCapacity = 5;
	public int luggageCapacity = 2;
	public int minDriverAge = 17;
	public int doorCount = 5;
	
	public boolean rentalRestrictions = false;
	public int minRentalHours = 24;
	public int maxRentalHours = 240;
	
	public int bookingCutoff;
	
	public double co2Emission;
	public double fuelEconomy;
	
	public String acrissCode;
	public String acrissCategory;
	public String acrissType;
	public String transmissionType;
	public String driveType;
	public String fuelType;
	public boolean airConditioning;

    public List<String> keywords = new ArrayList<>();
    public List<String> flags = new ArrayList<>();
		
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	
	public List<CarRentalLocationDto> pickupLocations = new ArrayList<>();
	public List<CarRentalLocationDto> dropoffLocations = new ArrayList<>();
	
	public List<TagGroupDto> tagGroups = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return description;
	}

	public void setSummary(String description) {
		this.description = description;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	@JsonIgnore
	public CarRentalLocationDto getPickup(CarQuery q) {
		for (CarRentalLocationDto l : pickupLocations) {
			if ( q.getPickupLocationIds().contains(l.id) ) {
				return l;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public CarRentalLocationDto getDropoff(CarQuery q) {
		for (CarRentalLocationDto l : dropoffLocations) {
			if ( q.getDropoffLocationIds().contains(l.id) ) {
				return l;
			}
		}
		return null;
	}
	
	@JsonIgnore
	public int getLocationPrice(CarQuery q) {
		if ( q.isAvailabilityQuery() ) {
			CarRentalLocationDto pickup = getPickup(q);
			CarRentalLocationDto dropoff = getDropoff(q);
			
			if ( pickup.id.equals(dropoff.id) ) {
				return pickup.priceForPickupAndDropoff;
			} else {
				return pickup.priceForPickup + dropoff.priceForDropoff;
			}
			
		} else {
			return 0;
		}
	}

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
}
