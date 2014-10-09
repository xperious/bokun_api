package is.bokun.dtos.pricing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlType(name = "CostMatrix")
@XmlAccessorType(XmlAccessType.FIELD)
public class CostMatrixDto {

    public Long id;
    public String title;
    public int sortIndex;

    public Long id1, id2, id3;

    public Long masterId;
    public PriceChangeTypeEnum priceChangeType;
    public Double amount;

    public List<CostMatrixAxisItemDto> axisItems = new ArrayList<>();

    public List<CostMatrixCellDto> cells = new ArrayList<>();

    public boolean getDependent() {
        return masterId != null && masterId > 0;
    }

    @JsonIgnore
    public CostMatrixCellDto findCell(Long fromAxisItemId, Long toAxisItemId) {
        for (CostMatrixCellDto cell : cells) {
            if ( cell.fromAxisItemId.equals(fromAxisItemId) && cell.toAxisItemId.equals(toAxisItemId) ) {
                return cell;
            }
        }
        return null;
    }
}
