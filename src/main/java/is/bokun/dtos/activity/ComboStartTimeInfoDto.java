package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComboStartTimeInfoDto {

    public Long targetActivityId;
    public Long targetStartTimeId;

    public ComboStartTimeInfoDto() {}

    public ComboStartTimeInfoDto(Long targetActivityId, Long targetStartTimeId) {
        this.targetActivityId = targetActivityId;
        this.targetStartTimeId = targetStartTimeId;
    }
}
