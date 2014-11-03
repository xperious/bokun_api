package is.bokun.dtos.accommodation;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.AvailabilityInfoDto;
import is.bokun.queries.AccommodationQuery;
import is.bokun.queries.RoomQuery;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AvailableRoomDto {
	
	public Long id;
	public Double totalPrice;
	public int maxBookableCount;

    public Map<Long,Double> extraPrices = new HashMap<>();

    public List<Integer> guestCounts = new ArrayList<>();

	public RoomTypeDto roomType;
	public List<AvailabilityInfoDto> availabilities = new ArrayList<>();
	
	public AvailableRoomDto() {}

	public AvailableRoomDto(Long id, Double totalPrice, int availableAcrossInterval, RoomTypeDto roomType, AccommodationQuery query) {
        this(id, totalPrice, availableAcrossInterval, roomType, query, false);
    }

    public AvailableRoomDto(Long id, Double totalPrice, int availableAcrossInterval, RoomTypeDto roomType, AccommodationQuery query, boolean showFullAvailability) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.roomType = roomType;

        this.maxBookableCount = roomType.shared && !showFullAvailability
                ? Math.min(availableAcrossInterval, query.totalCapacityNeeded())
                : availableAcrossInterval
                ;

        for ( RoomQuery rq : query.rooms ) {
            if ( rq.sleepingPlacesNeeded() <= roomType.capacity ) {
                this.guestCounts.add(rq.sleepingPlacesNeeded());
            }
        }
        if ( query.rooms.size() > 1 && query.totalCapacityNeeded() <= roomType.capacity ) {
            this.guestCounts.add(query.totalCapacityNeeded());
        }
        Collections.sort(this.guestCounts);
	}
    
}
