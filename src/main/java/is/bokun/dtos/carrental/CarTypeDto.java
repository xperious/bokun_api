package is.bokun.dtos.carrental;

import is.bokun.dtos.*;
import is.bokun.dtos.search.SearchResult;

import java.util.*;

public class CarTypeDto extends HasBookableExtras implements SearchResult, WithPhotos {

	public String id;
	public String title;
	public String description;
	public String exampleCarModel;
	
	public ItemDto vendor;
	public ItemDto carRental;
	
	public Integer price;
	
	public int passengerCapacity = 5;
	public int luggageCapacity = 2;
	public int minDriverAge = 17;
	
	public double co2Emission;
	public double fuelEconomy;
	
	public String acrissCategory;
	public String acrissType;
	public String transmissionType;
	public String driveType;
	public String fuelType;
	public boolean airConditioning;

    public List<String> keywords = new ArrayList<>();
		
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	
	public List<CarRentalLocationDto> pickupLocations = new ArrayList<>();
	public List<CarRentalLocationDto> dropoffLocations = new ArrayList<>();
	
	
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

	@Override
	public void addPhoto(PhotoDto p) {
		photos.add(p);
	}

	@Override
	public void setKeyPhoto(PhotoDto p) {
		keyPhoto = p;
	}
}
