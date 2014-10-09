package is.bokun.dtos.pricing;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "CostGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class CostGroupDto {

    public Long id;
    public String title;
    public CostGroupTypeEnum parentType;
    public Long parentId;
    public String externalId;

    @XmlElement(name="costItem")
    public List<CostItemDto> items = new ArrayList<>();

    @XmlElement(name="costMatrix")
    public List<CostMatrixDto> matrices = new ArrayList<>();

    @JsonIgnore
    public CostItemDto findCostItem(CostItemTypeEnum itemType, String itemId) {
        for (CostItemDto item : getItems()) {
            if ( item.getItemType() == itemType && item.getItemId().equals(itemId) ) {
                return item;
            }
        }
        return null;
    }

    @JsonIgnore
    public CostMatrixDto findCostMatrix(Long id1, Long id2, Long id3) {
        for (CostMatrixDto matrix : getMatrices()) {
            if ( equal(matrix.id1, id1) && equal(matrix.id2, id2) && equal(matrix.id3, id3) ) {
                return matrix;
            }
        }
        return null;
    }

    @JsonIgnore
    public CostMatrixDto findCostMatrixById(Long matrixId) {
        for (CostMatrixDto matrix : getMatrices()) {
            if ( equal(matrix.id, matrixId) ) {
                return matrix;
            }
        }
        return null;
    }

    private boolean equal(Long l1, Long l2) {
        return (l1 == null && l2 == null)
                || (l1 != null && l2 != null && l1.equals(l2));
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

    public List<CostMatrixDto> getMatrices() {
        return matrices;
    }

    public void setMatrices(List<CostMatrixDto> matrices) {
        this.matrices = matrices;
    }

    @Override
    public String toString() {
        return "CostGroupDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
