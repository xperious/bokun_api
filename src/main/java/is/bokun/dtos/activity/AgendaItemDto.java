package is.bokun.dtos.activity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import is.bokun.dtos.*;

import javax.xml.bind.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "agendaItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgendaItemDto {

    public Long id;
    public int index;
    public String title;
    public String body;
    public boolean possibleStartPoint;

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> flags = new ArrayList<>();

    public PlaceDto place;
    
    public PhotoDto keyPhoto;
    @XmlElementWrapper
    @XmlElement(name="photo")
    public List<PhotoDto> photos = new ArrayList<>();

    public AgendaItemDto() {}

    public AgendaItemDto(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    
}
