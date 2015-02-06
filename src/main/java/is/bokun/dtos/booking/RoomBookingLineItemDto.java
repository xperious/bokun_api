package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 15.1.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "roomBookingLineItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomBookingLineItemDto {

    public Long roomTypeId;
    public int quantity;
    public String bookedTitle;

    public RoomBookingLineItemDto() {}

    public RoomBookingLineItemDto(Long roomTypeId, String bookedTitle) {
        this.roomTypeId = roomTypeId;
        this.bookedTitle = bookedTitle;
        this.quantity = 1;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
