package is.bokun.integrate;

import is.bokun.dtos.booking.*;

public interface BookingConsumer {

	public boolean confirmBooking(BookingDetailsDto booking, BookingValueStore valueStore);
	
	public boolean updateAccommodationBooking(AccommodationBookingDetailsDto booking, BookingUpdateType updateType, BookingValueStore valueStore);
	public boolean updateActivityBooking(ActivityBookingDetailsDto booking, BookingUpdateType updateType, BookingValueStore valueStore);
	public boolean updateCarRentalBooking(CarRentalBookingDetailsDto booking, BookingUpdateType updateType, BookingValueStore valueStore);
	
	public boolean cancelBooking(BookingDetailsDto booking, BookingValueStore valueStore);
	public boolean cancelAccommodationBooking(AccommodationBookingDetailsDto booking, BookingValueStore valueStore);
	public boolean cancelActivityBooking(ActivityBookingDetailsDto booking, BookingValueStore valueStore);
	public boolean cancelCarRentalBooking(CarRentalBookingDetailsDto booking, BookingValueStore valueStore);

}
