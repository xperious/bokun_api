package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelBookingDto {

    public String note;

    public Boolean notify;

    public Boolean refund;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }

    public Boolean getRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

}
