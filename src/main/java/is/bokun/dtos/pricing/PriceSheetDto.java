package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PriceSheetDto {

    public Long id;
    public String title;
    public List<PriceSheetDateRangeDto> dateRanges = new ArrayList<>();

    public List<CostGroupDto> costGroups = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PriceSheetDateRangeDto> getDateRanges() {
        return dateRanges;
    }

    public void setDateRanges(List<PriceSheetDateRangeDto> dateRanges) {
        this.dateRanges = dateRanges;
    }

    public List<CostGroupDto> getCostGroups() {
        return costGroups;
    }

    public void setCostGroups(List<CostGroupDto> costGroups) {
        this.costGroups = costGroups;
    }

    @JsonIgnore
    public CostGroupDto findCostGroup(CostGroupTypeEnum parentType, Long parentId) {
        for (CostGroupDto grp : getCostGroups()) {
            if (grp.getParentType() == parentType && grp.getParentId().equals(parentId)) {
                return grp;
            }
        }
        return null;
    }
}
