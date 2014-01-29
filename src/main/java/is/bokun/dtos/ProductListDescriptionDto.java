package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductListDescriptionDto {

    public Long id;
    public String title;
    public String description;
    public String slug;
    public List<String> flags = new ArrayList<>();
    public Integer size;
}
