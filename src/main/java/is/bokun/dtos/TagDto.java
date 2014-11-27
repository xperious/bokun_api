package is.bokun.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ogg on 20.11.2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "Tag")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class TagDto {

    public Long id;
    public Long ownerId;
    public Long groupId, parentTagId;
    public String title;
    public String facetName;
    public boolean exclusive;
    public List<String> flags = new ArrayList<>();
}
