package is.bokun.queries;

import is.bokun.utils.*;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Query object for searching rental cars.
 *
 * @author Olafur Gauti Gudmundsson
 */
public class CarQuery extends AbstractDateRangeQuery {
	
	public static final String[] DATE_FORMATS = {"yyyy-MM-dd HH:mm", "dd.MM.yy HH:mm", "dd.MM.yyyy HH:mm"};
	
	/**
	 * Set this to get results for specific car rentals only.
	 */
	public List<Long> carRentalIds = new ArrayList<>();
	
	/**
	 * Set this to get results for specific car types only.
	 */
	public List<Long> carTypeIds = new ArrayList<>();
	
	/**
	 * Set this to filter results by flags.
	 */
	public List<String> flags = new ArrayList<>();
	
	/**
	 * Set this to get results for the single a car rental that has this (language dependent) slug.
	 */
	public String carRentalSlug;
	
	/**
	 * Set to get only cars that allow this driver age (and above). 
	 */
	public Integer driverAge;
	
	/**
	 * Set to get only cars where passenger capacity is greater than or equal to this.
	 */
	public Integer passengers;
	
	/**
	 * Set to get only cars where luggage capacity is greater than or equal to this.
	 */
	public Integer luggage;
	
	/**
	 * Set to get only cars where door count is greater than or equal to this.
	 */
	public Integer minDoorCount;
	
	/**
	 * Set to filter by CO2 emission (g/km).
	 */
	public NumericRangeFilter co2EmissionFilter;
	
	/**
	 * Set to filter by fuel economy (L/100km).
	 */
	public NumericRangeFilter fuelEconomyFilter;
	
	/**
	 * Set to filter by air conditioning.
	 */
	public Boolean airConditioning;

    /**
     * Find cars that have pickup location that matches this filter.
     */
	public LocationFilters pickupLocationFilters = new LocationFilters();
	
    /**
     * Find cars that have dropoff location that matches this filter.
     */
	public LocationFilters dropoffLocationFilters = new LocationFilters();
	
	/**
	 * Set this to get results for specific pickup locations only.
	 */
	public List<Long> pickupLocationIds = new ArrayList<>();
	
	/**
	 * Set this to get results for specific dropoff locations only.
	 */
	public List<Long> dropoffLocationIds = new ArrayList<>();

	public CarQuery() {
		super(DATE_FORMATS);
	}
	
	@JsonIgnore
	public int getRentalDayCount() {
		if ( isAvailabilityQuery() ) {
			return DateUtils.getRentalDayCount(parseStartDate(), parseEndDate());
		} else {
			return 0;
		}
	}

	public List<Long> getCarRentalIds() {
		return carRentalIds;
	}

	public void setCarRentalIds(List<Long> carRentalIds) {
		this.carRentalIds = carRentalIds;
	}

	public Integer getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(Integer driverAge) {
		this.driverAge = driverAge;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	public Integer getLuggage() {
		return luggage;
	}

	public void setLuggage(Integer luggage) {
		this.luggage = luggage;
	}

	public Integer getMinDoorCount() {
		return minDoorCount;
	}

	public void setMinDoorCount(Integer minDoorCount) {
		this.minDoorCount = minDoorCount;
	}

	public LocationFilters getPickupLocationFilters() {
		return pickupLocationFilters;
	}

	public void setPickupLocationFilters(LocationFilters pickupLocationFilters) {
		this.pickupLocationFilters = pickupLocationFilters;
	}

	public LocationFilters getDropoffLocationFilters() {
		return dropoffLocationFilters;
	}

	public void setDropoffLocationFilters(LocationFilters dropoffLocationFilters) {
		this.dropoffLocationFilters = dropoffLocationFilters;
	}

	public List<Long> getPickupLocationIds() {
		return pickupLocationIds;
	}

	public void setPickupLocationIds(List<Long> pickupLocationIds) {
		this.pickupLocationIds = pickupLocationIds;
	}

	public List<Long> getDropoffLocationIds() {
		return dropoffLocationIds;
	}

	public void setDropoffLocationIds(List<Long> dropoffLocationIds) {
		this.dropoffLocationIds = dropoffLocationIds;
	}

	public NumericRangeFilter getCo2EmissionFilter() {
		return co2EmissionFilter;
	}

	public void setCo2EmissionFilter(NumericRangeFilter co2EmissionFilter) {
		this.co2EmissionFilter = co2EmissionFilter;
	}

	public NumericRangeFilter getFuelEconomyFilter() {
		return fuelEconomyFilter;
	}

	public void setFuelEconomyFilter(NumericRangeFilter fuelEconomyFilter) {
		this.fuelEconomyFilter = fuelEconomyFilter;
	}

	public Boolean getAirConditioning() {
		return airConditioning;
	}

	public void setAirConditioning(Boolean airConditioning) {
		this.airConditioning = airConditioning;
	}
	
	public String getCarRentalSlug() {
		return carRentalSlug;
	}

	public void setCarRentalSlug(String carRentalSlug) {
		this.carRentalSlug = carRentalSlug;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}

	public List<Long> getCarTypeIds() {
		return carTypeIds;
	}

	public void setCarTypeIds(List<Long> carTypeIds) {
		this.carTypeIds = carTypeIds;
	}

	@JsonIgnore
	public CarQueryTime getStartTime() {
		Date startDate = parseStartDate();
		if ( startDate == null ) {
			return new CarQueryTime(12,0);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		
		return new CarQueryTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
	}
	
	@JsonIgnore
	public CarQueryTime getEndTime() {
		Date endDate = parseEndDate();
		if ( endDate == null ) {
			return new CarQueryTime(14,0);
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		
		return new CarQueryTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
	}

	@JsonIgnore
	public CarSortField sortField() {
		if ( StringUtils.isNullOrEmpty(sortField) ) {
			return null;
		} else {
			try {
				return CarSortField.valueOf(sortField.toUpperCase());
			} catch ( Throwable ignored ) {
				return null;
			}
		}
	}
	
	public static class CarQueryTime {
		public int hour;
		public int minute;
		
		public CarQueryTime() {}
		
		public CarQueryTime(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}
		
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getMinute() {
			return minute;
		}
		public void setMinute(int minute) {
			this.minute = minute;
		}
	}
}
