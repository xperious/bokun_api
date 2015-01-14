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
    public Double deliveryFee;
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

    public int defaultPickupHour;
    public int defaultPickupMinute;
    public int defaultDropoffHour;
    public int defaultDropoffMinute;

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

    public Double getDeliveryFee() {
        return deliveryFee;
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

    /**
     * @deprecated  Use the deliveryFee field instead.
     * @param q
     * @return
     */
	@JsonIgnore @Deprecated
	public Double getLocationPrice(CarQuery q) {
        return deliveryFee;
        /*
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
		}*/
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExampleCarModel() {
		return exampleCarModel;
	}

	public void setExampleCarModel(String exampleCarModel) {
		this.exampleCarModel = exampleCarModel;
	}

	public void setBaseLanguage(String baseLanguage) {
		this.baseLanguage = baseLanguage;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public ItemDto getVendor() {
		return vendor;
	}

	public void setVendor(ItemDto vendor) {
		this.vendor = vendor;
	}

	public ItemDto getCarRental() {
		return carRental;
	}

	public void setCarRental(ItemDto carRental) {
		this.carRental = carRental;
	}

	public Double getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public Double getAvgRentalPricePerDay() {
		return avgRentalPricePerDay;
	}

	public void setAvgRentalPricePerDay(Double avgRentalPricePerDay) {
		this.avgRentalPricePerDay = avgRentalPricePerDay;
	}

	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Integer getMaxBookableCount() {
		return maxBookableCount;
	}

	public void setMaxBookableCount(Integer maxBookableCount) {
		this.maxBookableCount = maxBookableCount;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public int getLuggageCapacity() {
		return luggageCapacity;
	}

	public void setLuggageCapacity(int luggageCapacity) {
		this.luggageCapacity = luggageCapacity;
	}

	public int getMinDriverAge() {
		return minDriverAge;
	}

	public void setMinDriverAge(int minDriverAge) {
		this.minDriverAge = minDriverAge;
	}

	public int getDoorCount() {
		return doorCount;
	}

	public void setDoorCount(int doorCount) {
		this.doorCount = doorCount;
	}

	public boolean isRentalRestrictions() {
		return rentalRestrictions;
	}

	public void setRentalRestrictions(boolean rentalRestrictions) {
		this.rentalRestrictions = rentalRestrictions;
	}

	public int getMinRentalHours() {
		return minRentalHours;
	}

	public void setMinRentalHours(int minRentalHours) {
		this.minRentalHours = minRentalHours;
	}

	public int getMaxRentalHours() {
		return maxRentalHours;
	}

	public void setMaxRentalHours(int maxRentalHours) {
		this.maxRentalHours = maxRentalHours;
	}

	public int getBookingCutoff() {
		return bookingCutoff;
	}

	public void setBookingCutoff(int bookingCutoff) {
		this.bookingCutoff = bookingCutoff;
	}

	public double getCo2Emission() {
		return co2Emission;
	}

	public void setCo2Emission(double co2Emission) {
		this.co2Emission = co2Emission;
	}

	public double getFuelEconomy() {
		return fuelEconomy;
	}

	public void setFuelEconomy(double fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}

	public String getAcrissCode() {
		return acrissCode;
	}

	public void setAcrissCode(String acrissCode) {
		this.acrissCode = acrissCode;
	}

	public String getAcrissCategory() {
		return acrissCategory;
	}

	public void setAcrissCategory(String acrissCategory) {
		this.acrissCategory = acrissCategory;
	}

	public String getAcrissType() {
		return acrissType;
	}

	public void setAcrissType(String acrissType) {
		this.acrissType = acrissType;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public boolean isAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public List<Long> getPriceModulatorIds() {
		return priceModulatorIds;
	}

	public void setPriceModulatorIds(List<Long> priceModulatorIds) {
		this.priceModulatorIds = priceModulatorIds;
	}

	public List<CarRentalLocationDto> getPickupLocations() {
		return pickupLocations;
	}

	public void setPickupLocations(List<CarRentalLocationDto> pickupLocations) {
		this.pickupLocations = pickupLocations;
	}

	public List<CarRentalLocationDto> getDropoffLocations() {
		return dropoffLocations;
	}

	public void setDropoffLocations(List<CarRentalLocationDto> dropoffLocations) {
		this.dropoffLocations = dropoffLocations;
	}

	public Long getDefaultPickupLocationId() {
		return defaultPickupLocationId;
	}

	public void setDefaultPickupLocationId(Long defaultPickupLocationId) {
		this.defaultPickupLocationId = defaultPickupLocationId;
	}

	public Long getDefaultDropoffLocationId() {
		return defaultDropoffLocationId;
	}

	public void setDefaultDropoffLocationId(Long defaultDropoffLocationId) {
		this.defaultDropoffLocationId = defaultDropoffLocationId;
	}

	public int getDefaultPickupHour() {
		return defaultPickupHour;
	}

	public void setDefaultPickupHour(int defaultPickupHour) {
		this.defaultPickupHour = defaultPickupHour;
	}

	public int getDefaultPickupMinute() {
		return defaultPickupMinute;
	}

	public void setDefaultPickupMinute(int defaultPickupMinute) {
		this.defaultPickupMinute = defaultPickupMinute;
	}

	public int getDefaultDropoffHour() {
		return defaultDropoffHour;
	}

	public void setDefaultDropoffHour(int defaultDropoffHour) {
		this.defaultDropoffHour = defaultDropoffHour;
	}

	public int getDefaultDropoffMinute() {
		return defaultDropoffMinute;
	}

	public void setDefaultDropoffMinute(int defaultDropoffMinute) {
		this.defaultDropoffMinute = defaultDropoffMinute;
	}

	public List<TagGroupDto> getTagGroups() {
		return tagGroups;
	}

	public void setTagGroups(List<TagGroupDto> tagGroups) {
		this.tagGroups = tagGroups;
	}

	public List<String> getPaymentCurrencies() {
		return paymentCurrencies;
	}

	public void setPaymentCurrencies(List<String> paymentCurrencies) {
		this.paymentCurrencies = paymentCurrencies;
	}
}
