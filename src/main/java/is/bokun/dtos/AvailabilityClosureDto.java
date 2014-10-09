package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "availabilityClosure")
@XmlType(name = "AvailabilityClosure")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityClosureDto extends AvailabilityBaseDto {

    public List<AvailabilityItemClosureDto> closedItems = new ArrayList<>();

    public List<AvailabilityItemClosureDto> getClosedItems() {
        return closedItems;
    }

    public void setClosedItems(List<AvailabilityItemClosureDto> closedItems) {
        this.closedItems = closedItems;
    }
}
