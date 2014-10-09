package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 2.10.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "BookingAgentWithLinks")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookingAgentWithLinksDto extends BookingAgentDto {

    public List<LinkedExternalCustomerDto> linkedExternalCustomers = new ArrayList<>();

    public List<LinkedExternalCustomerDto> getLinkedExternalCustomers() {
        return linkedExternalCustomers;
    }

    public void setLinkedExternalCustomers(List<LinkedExternalCustomerDto> linkedExternalCustomers) {
        this.linkedExternalCustomers = linkedExternalCustomers;
    }
}
