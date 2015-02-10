package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarRentalLocationDto;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarRentalBookingQuestionsDto {

	public BookingItemInfoDto carRental;
	public Long bookingId;
	public Date startDate, endDate;
	public CarRentalLocationDto pickupLocation, dropoffLocation;
	
	public List<BookingQuestionGroupDto> questionGroups = new ArrayList<>();
	
	public List<CarBookingQuestionsDto> carBookings = new ArrayList<>();
	
    @JsonIgnore
    public boolean hasQuestions() {
        for (BookingQuestionGroupDto g : questionGroups) {
            if ( !g.questions.isEmpty() ) {
                return true;
            }
        }

        for (CarBookingQuestionsDto r : carBookings) {
            if ( r.hasQuestions() ) {
                return true;
            }
        }

        return false;
    }

    public BookingItemInfoDto getCarRental() {
        return carRental;
    }

    public void setCarRental(BookingItemInfoDto carRental) {
        this.carRental = carRental;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CarRentalLocationDto getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(CarRentalLocationDto pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public CarRentalLocationDto getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(CarRentalLocationDto dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public List<BookingQuestionGroupDto> getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(List<BookingQuestionGroupDto> questionGroups) {
        this.questionGroups = questionGroups;
    }

    public List<CarBookingQuestionsDto> getCarBookings() {
        return carBookings;
    }

    public void setCarBookings(List<CarBookingQuestionsDto> carBookings) {
        this.carBookings = carBookings;
    }
}
