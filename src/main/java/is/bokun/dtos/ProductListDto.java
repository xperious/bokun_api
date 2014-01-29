package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductListDto extends ProductListDescriptionDto {

    public List<ProductListItemDto> items = new ArrayList<>();
}
