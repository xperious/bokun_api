package is.bokun.dtos.transport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.AbstractIdDto;
import is.bokun.dtos.LocationDto;
import is.bokun.dtos.RegionDto;
import is.bokun.utils.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "RouteStation")
@XmlAccessorType(XmlAccessType.FIELD)
public class RouteStationDto extends AbstractIdDto {

    public String title, shortTitle;
    public boolean pickupStation;
    public Long pickupPlaceId;
    public LocationDto location;

    public List<RegionDto> regions = new ArrayList<>();

    public List<String> flags = new ArrayList<>();

    public List<String> pickupFlags = new ArrayList<>();

    public RouteStationDto(){}

    public RouteStationDto(String title, String shortTitle) {
        this.title = title;
        this.shortTitle = shortTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getShortOrLongTitle() {
        if ( !StringUtils.isNullOrEmpty(shortTitle) ) {
            return shortTitle;
        } else {
            return title;
        }
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public List<RegionDto> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionDto> regions) {
        this.regions = regions;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public void setPickupStation(boolean pickupStation) {
        this.pickupStation = pickupStation;
    }

    public Long getPickupPlaceId() {
        return pickupPlaceId;
    }

    public void setPickupPlaceId(Long pickupPlaceId) {
        this.pickupPlaceId = pickupPlaceId;
    }

    @JsonIgnore
    public boolean inRegion(RegionDto region) {
        for (RegionDto r : regions ) {
            if (r.equals(region)) {
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public Set<RegionDto> getRegionSet() {
        Set<RegionDto> s = new HashSet<>();
        s.addAll(regions);
        return s;
    }
}
