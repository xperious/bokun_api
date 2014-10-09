package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kristinfjola on 17.7.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "integratedSystemConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegratedSystemConfigDto {

    public Long id;

    public String systemType;

    public String title;

    public IntegratedSystemConfigDto() {}

    public IntegratedSystemConfigDto(Long id, String systemType, String title) {
        this.id = id;
        this.systemType = systemType;
        this.title = title;
    }
}
