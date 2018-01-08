package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum SelectionTypeEnum {

    OPTIONAL,
    PRESELECTED,
    UNAVAILABLE;

}
