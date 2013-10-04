package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface WithExtras {

    public BookableExtraDto findExtra(Long id);
}
