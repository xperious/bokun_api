package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ogg on 19.12.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceDto {

    public Long id;
    public ResourceTypeEnum type;
    public String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResourceTypeEnum getType() {
        return type;
    }

    public void setType(ResourceTypeEnum type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
