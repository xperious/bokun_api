package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by ogg on 12.9.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "CostMatrixAxisItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class CostMatrixAxisItemDto {

    public Long id;
    public int sortIndex;

    public String title;
    public String externalId;

    public CostMatrixAxisItemTypeEnum itemType;
    public Long itemId;
}
