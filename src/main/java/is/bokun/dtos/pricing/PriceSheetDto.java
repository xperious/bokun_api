package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PriceSheet")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceSheetDto {

    public Long id;
    public String title;

    @XmlElement(name="dateRange")
    public List<PriceSheetDateRangeDto> dateRanges = new ArrayList<>();

    @XmlElement(name="costGroup")
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
        Collections.sort(dateRanges, new Comparator<PriceSheetDateRangeDto>() {
            @Override
            public int compare(PriceSheetDateRangeDto o1, PriceSheetDateRangeDto o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });
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
    public PriceSheetDateRangeDto findDateRange(Date d) {
        List<PriceSheetDateRangeDto> dateRanges = getDateRanges();
        DateTime dateTime = new DateTime(d);
        for (int i = 0; i < dateRanges.size(); i++) {
            PriceSheetDateRangeDto current = dateRanges.get(i);
            PriceSheetDateRangeDto next = null;
            if ( i < dateRanges.size()-1 ) {
                next = dateRanges.get(i+1);
            }

            boolean isEqualOrAfterThisRange = dateTime.isEqual(current.getStart().getTime()) || dateTime.isAfter(current.getStart().getTime());
            if ( isEqualOrAfterThisRange && (next == null || dateTime.isBefore(next.getStart().getTime())) ) {
                return current;
            }
        }
        return null;
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
