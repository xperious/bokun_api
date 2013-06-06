package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarRentalLocationDto;

import java.util.*;

public class CarRentalBookingQuestionsDto {

	public BookingItemInfoDto carRental;
	public Long bookingId;
	public Date startDate, endDate;
	public String pickupTime, dropoffTime;
	public CarRentalLocationDto pickupLocation, dropoffLocation;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<>();
	
	public List<CarBookingQuestionsDto> carBookings = new ArrayList<>();
}
