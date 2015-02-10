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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getMaxBookableCount() {
        return maxBookableCount;
    }

    public void setMaxBookableCount(int maxBookableCount) {
        this.maxBookableCount = maxBookableCount;
    }

    public Map<Long, Double> getExtraPrices() {
        return extraPrices;
    }

    public void setExtraPrices(Map<Long, Double> extraPrices) {
        this.extraPrices = extraPrices;
    }

    public List<Integer> getGuestCounts() {
        return guestCounts;
    }

    public void setGuestCounts(List<Integer> guestCounts) {
        this.guestCounts = guestCounts;
    }

    public RoomTypeDto getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeDto roomType) {
        this.roomType = roomType;
    }

    public List<AvailabilityInfoDto> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<AvailabilityInfoDto> availabilities) {
        this.availabilities = availabilities;
    }
}
