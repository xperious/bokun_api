package is.bokun.integrate;

import is.bokun.dtos.booking.BookingDetailsDto;

public interface BookingConsumer {

	public boolean consume(BookingDetailsDto booking);
}
