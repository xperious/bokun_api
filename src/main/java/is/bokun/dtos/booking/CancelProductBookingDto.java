package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelProductBookingDto {

    private String note;

    private Boolean notify;

    private Boolean refund;

    private Long refundAmount;

    private Boolean remainInvoiced;

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

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Boolean getRemainInvoiced() {
        return remainInvoiced;
    }

    public void setRemainInvoiced(Boolean remainInvoiced) {
        this.remainInvoiced = remainInvoiced;
    }
}
