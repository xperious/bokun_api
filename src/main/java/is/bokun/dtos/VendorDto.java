package is.bokun.dtos;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "vendor")
@XmlAccessorType(XmlAccessType.FIELD)
public class VendorDto {

	public Long id;
	
	public String title;
	
	public String currencyCode;

    public String phoneNumber;
    public String emailAddress;
    public String website;
    public String logoStyle;
    public String invoiceIdNumber;
    public PhotoDto logo;

    public VendorDto() {}

    public VendorDto(Long id, String title, String currencyCode) {
        this.id = id;
        this.title = title;
        this.currencyCode = currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogoStyle() {
        return logoStyle;
    }

    public void setLogoStyle(String logoStyle) {
        this.logoStyle = logoStyle;
    }

    public String getInvoiceIdNumber() {
        return invoiceIdNumber;
    }

    public void setInvoiceIdNumber(String invoiceIdNumber) {
        this.invoiceIdNumber = invoiceIdNumber;
    }

    public PhotoDto getLogo() {
        return logo;
    }

    public void setLogo(PhotoDto logo) {
        this.logo = logo;
    }
}
