package is.bokun.dtos.accommodation;

import java.util.*;

public class AccommodationAvailabilitiesDto {

	public String startDate, endDate;
	public List<AccommodationReport> accommodations = new ArrayList<>();
	
	public AccommodationAvailabilitiesDto() {}
	
	public AccommodationAvailabilitiesDto(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public void add(AccommodationDto accommodation) {
		AccommodationReport report = new AccommodationReport();
		report.accommodation = accommodation;
		accommodations.add(report);
	}
	
	public void addRoom(Long roomTypeId, List<RoomAvailabilityReport> roomAvailabilities) {
		for (AccommodationReport report : accommodations) {
			RoomTypeDto rtype = report.accommodation.findRoomType(roomTypeId);
			if ( rtype != null ) {
				report.rooms.add(new RoomReport(rtype, roomAvailabilities));
				break;
			}
		}
	}
	
	
	public static class AccommodationReport {
		
		public AccommodationDto accommodation;
		
		public List<RoomReport> rooms = new ArrayList<>();
	}
	
	public static class RoomReport {
		
		public RoomTypeDto room;
		
		public List<RoomAvailabilityReport> availabilities = new ArrayList<>();

		public Integer minimumAvailability;
		
		public RoomReport() {}
		
		public RoomReport(RoomTypeDto room, List<RoomAvailabilityReport> availabilities) {
			this.room = room;
			this.availabilities = availabilities;
		}
	}
	
	public static class RoomAvailabilityReport {
		
		public String date;
		
		public int available;
		public Double price;

		public List<RatePrice> ratePrices = new ArrayList<>();
	}

	public static class RatePrice {
		public Long rateId;
		public Double price;
		public Boolean closed;
		public Boolean closedForArrival;
		public Boolean closedForDeparture;
	}

}
