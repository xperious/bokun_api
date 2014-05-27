package is.bokun.dtos;

/**
 * Created by ogg on 22/5/14.
 */
public class NameValuePairDto {

    public String name;
    public String value;

    public NameValuePairDto() {}

    public NameValuePairDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
