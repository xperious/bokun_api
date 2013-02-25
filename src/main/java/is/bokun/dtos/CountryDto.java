package is.bokun.dtos;

/**
 * A DTO containing the title and ISO code of a Country.
 *
 * @author Olafur Gauti Gudmundsson
 */
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
