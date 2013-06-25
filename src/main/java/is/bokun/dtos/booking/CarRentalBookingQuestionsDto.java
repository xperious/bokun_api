package is.bokun.dtos.booking;

import is.bokun.dtos.carrental.CarRentalLocationDto;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnore;

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
}
