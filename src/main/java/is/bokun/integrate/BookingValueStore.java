package is.bokun.integrate;

import is.bokun.dtos.booking.*;

public interface BookingValueStore {

	public void store(BookingDetailsDto booking, String name, String value);
	public void remove(BookingDetailsDto booking, String name);
	
	public void store(ProductBookingDetailsDto productBooking, String name, String value);
	public void remove(ProductBookingDetailsDto productBooking, String name);
}
