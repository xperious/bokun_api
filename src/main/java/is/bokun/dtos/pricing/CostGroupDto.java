package is.bokun.dtos.pricing;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CostGroupDto {

    public Long id;
    public String title;
    public CostGroupTypeEnum parentType;
    public Long parentId;
    public String externalId;

    public List<CostItemDto> items = new ArrayList<>();

    @JsonIgnore
    public CostItemDto findCostItem(CostItemTypeEnum itemType, String itemId) {
        for (CostItemDto item : getItems()) {
            if ( item.getItemType() == itemType && item.getItemId().equals(itemId) ) {
                return item;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CostGroupTypeEnum getParentType() {
        return parentType;
    }

    public void setParentType(CostGroupTypeEnum parentType) {
        this.parentType = parentType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<CostItemDto> getItems() {
        return items;
    }

    public void setItems(List<CostItemDto> items) {
        this.items = items;
    }
}
