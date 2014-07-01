package is.bokun.dtos.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComboStartTimeInfoDto {

    public Long id;
    public Long targetActivityId;
    public Long targetStartTimeId;

    public ComboStartTimeInfoDto() {}

    public ComboStartTimeInfoDto(Long id, Long targetActivityId, Long targetStartTimeId) {
        this.id = id;
        this.targetActivityId = targetActivityId;
        this.targetStartTimeId = targetStartTimeId;
    }
}
