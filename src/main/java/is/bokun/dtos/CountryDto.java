package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A DTO containing the title and ISO code of a Country.
 *
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {

    public String isoCode;
    public String title;

    public CountryDto() {}

    public CountryDto(String isoCode, String title) {
        this.isoCode = isoCode;
        this.title = title;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
