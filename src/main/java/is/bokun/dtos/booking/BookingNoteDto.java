package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "bookingNote")
@XmlType(name = "BookingNote")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingNoteDto {

    public Date created;
    public String author;
    public String subject;
    public String body;

    public boolean sentAsEmail;
    public boolean voucherAttached;
    public boolean voucherPricesShown;
    public String recipient;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSentAsEmail(boolean sentAsEmail) {
        this.sentAsEmail = sentAsEmail;
    }

    public void setVoucherAttached(boolean voucherAttached) {
        this.voucherAttached = voucherAttached;
    }

    public void setVoucherPricesShown(boolean voucherPricesShown) {
        this.voucherPricesShown = voucherPricesShown;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
