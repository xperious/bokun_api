package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 7.8.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "IntegratedSystemProductLink")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegratedSystemProductLinkDto {

    public String externalProductId;
    public String externalProductTitle;
    public Long systemConfigId;

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    public IntegratedSystemProductLinkDto(){}

    public IntegratedSystemProductLinkDto(Long systemConfigId, String externalProductId, String externalProductTitle, List<String> flags) {
        this.systemConfigId = systemConfigId;
        this.externalProductId = externalProductId;
        this.externalProductTitle = externalProductTitle;
        this.flags = flags;
    }

    public String getExternalProductId() {
        return externalProductId;
    }

    public void setExternalProductId(String externalProductId) {
        this.externalProductId = externalProductId;
    }

    public String getExternalProductTitle() {
        return externalProductTitle;
    }

    public void setExternalProductTitle(String externalProductTitle) {
        this.externalProductTitle = externalProductTitle;
    }

    public Long getSystemConfigId() {
        return systemConfigId;
    }

    public void setSystemConfigId(Long systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
