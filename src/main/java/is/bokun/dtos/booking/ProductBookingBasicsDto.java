package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "ProductBookingBasics")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBookingBasicsDto {

    public Long id;
    public String productConfirmationCode;
    public ProductInfoDto product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductConfirmationCode() {
        return productConfirmationCode;
    }

    public void setProductConfirmationCode(String productConfirmationCode) {
        this.productConfirmationCode = productConfirmationCode;
    }

    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }
}
