package is.bokun.dtos.carrental;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.*;
import is.bokun.dtos.search.SearchResult;
import is.bokun.queries.CarQuery;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CarTypeDto extends HasBookableExtras implements SearchResult, WithPhotos {

	public Long id;
	public String title;	
	public String description;
	public String exampleCarModel;
	
    public String baseLanguage;
    public List<String> languages = new ArrayList<>();
	
	public ItemDto vendor;
	public ItemDto carRental;
	
	public Double rentalPrice;
	public Double avgRentalPricePerDay;
    public Integer maxBookableCount;
	
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
    
    public List<Long> priceModulatorIds = new ArrayList<>();
		
	public PhotoDto keyPhoto;
	public List<PhotoDto> photos = new ArrayList<>();
	
	public List<CarRentalLocationDto> pickupLocations = new ArrayList<>();
	public List<CarRentalLocationDto> dropoffLocations = new ArrayList<>();

    public Long defaultPickupLocationId;
    public Long defaultDropoffLocationId;

    public CarTypeDto() {}

    public CarTypeDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

	public List<TagGroupDto> tagGroups = new ArrayList<>();

    public List<String> paymentCurrencies = new ArrayList<>();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBaseLanguage() {
		return baseLanguage;
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
    public CarRentalLocationDto findPickupLocation(Long id) {
        for (CarRentalLocationDto l : pickupLocations) {
            if ( id.equals(l.id) ) {
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
    public CarRentalLocationDto findDropoffLocation(Long id) {
        for (CarRentalLocationDto l : dropoffLocations) {
            if ( id.equals(l.id) ) {
                return l;
            }
        }
        return null;
    }
	
	@JsonIgnore
	public Double getLocationPrice(CarQuery q) {
		if ( q.isAvailabilityQuery() ) {
			CarRentalLocationDto pickup = getPickup(q);
			CarRentalLocationDto dropoff = getDropoff(q);
			
			if ( pickup == null || dropoff == null ) {
				return 0d;
			}

			if ( pickup.id.equals(dropoff.id) ) {
				return pickup.priceForPickupAndDropoff;
			} else if ( pickup.priceForPickup != null && dropoff.priceForDropoff != null ) {
				return pickup.priceForPickup + dropoff.priceForDropoff;
			} else {
                return null;
            }

		} else {
			return 0d;
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
