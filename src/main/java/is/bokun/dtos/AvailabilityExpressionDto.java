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
@XmlRootElement(name = "availabilityExpression")
@XmlType(name = "AvailabilityExpression")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityExpressionDto extends AvailabilityBaseDto {

    public List<AvailabilityItemCapacityDto> capacities = new ArrayList<>();

    public List<AvailabilityItemCapacityDto> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<AvailabilityItemCapacityDto> capacities) {
        this.capacities = capacities;
    }
}
