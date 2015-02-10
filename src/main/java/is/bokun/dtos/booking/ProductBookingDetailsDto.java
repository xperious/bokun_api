package is.bokun.dtos.booking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.IntegratedSystemProductLinkDto;
import is.bokun.dtos.VendorWithLinksDto;
import is.bokun.utils.PriceUtils;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Olafur Gauti Gudmundsson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "productBooking")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBookingDetailsDto {

	@XmlElement(name = "id")
    public Long bookingId;
	public Long parentBookingId;
	
	public String confirmationCode;
    public String productConfirmationCode;

    public String barcodeUrl;

    @XmlElement
    public BookingStatusEnum status;

    @XmlElement
    public Date cancellationDate;
    @XmlElement
    public String cancelledBy;
    @XmlElement
    public String cancelNote;

	@XmlTransient
    public String title;
	
    public Double totalPrice;
    public Double priceWithDiscount;
    
	public Double discountPercentage;
	public Double discountAmount;

    public Double sellerCommission;
    public Double agentCommission;
    public Double affiliateCommission;
    
    @XmlTransient
    public String productCategory;
    
    public PaymentPaidTypeEnum paidType;
    
    public ProductInfoDto product = new ProductInfoDto();

    public VendorWithLinksDto supplier, seller;
    
    @XmlTransient
    public Long productId;

    @XmlElementWrapper
    @XmlElement(name="externalProductLink")
    public List<IntegratedSystemProductLinkDto> linksToExternalProducts = new ArrayList<>();

	@XmlElementWrapper
	@XmlElement(name="answer")
    public List<BookingAnswerDto> answers = new ArrayList<>();

    public InvoiceDto invoice;

    @XmlElementWrapper
    @XmlElement(name="note")
    public List<BookingNoteDto> notes = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> supplierContractFlags = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name="flag")
    public List<String> sellerContractFlags = new ArrayList<>();

    public BookingDetailsDto parentBooking;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getParentBookingId() {
		return parentBookingId;
	}

	public void setParentBookingId(Long parentBookingId) {
		this.parentBookingId = parentBookingId;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

    public BookingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookingStatusEnum status) {
        this.status = status;
    }

    public String getProductConfirmationCode() {
        return productConfirmationCode;
    }

    public void setProductConfirmationCode(String productConfirmationCode) {
        this.productConfirmationCode = productConfirmationCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPriceWithDiscount() {
		return priceWithDiscount;
	}

	public void setPriceWithDiscount(Double priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

    public List<IntegratedSystemProductLinkDto> getLinksToExternalProducts() {
        return linksToExternalProducts;
    }

    public void setLinksToExternalProducts(List<IntegratedSystemProductLinkDto> linksToExternalProducts) {
        this.linksToExternalProducts = linksToExternalProducts;
    }

    public Double getSellerCommission() {
        return sellerCommission;
    }

    public void setSellerCommission(Double sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    public Double getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(Double agentCommission) {
        this.agentCommission = agentCommission;
    }

    public Double getAffiliateCommission() {
        return affiliateCommission;
    }

    public void setAffiliateCommission(Double affiliateCommission) {
        this.affiliateCommission = affiliateCommission;
    }

    public List<BookingAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<BookingAnswerDto> answers) {
        this.answers = answers;
    }

    public PaymentPaidTypeEnum getPaidType() {
		return paidType;
	}

	public void setPaidType(PaymentPaidTypeEnum paidType) {
		this.paidType = paidType;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }

    public List<BookingNoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<BookingNoteDto> notes) {
        this.notes = notes;
    }

    public BookingDetailsDto getParentBooking() {
        return parentBooking;
    }

    public void setParentBooking(BookingDetailsDto parentBooking) {
        this.parentBooking = parentBooking;
    }

    public VendorWithLinksDto getSupplier() {
        return supplier;
    }

    public void setSupplier(VendorWithLinksDto supplier) {
        this.supplier = supplier;
    }

    public VendorWithLinksDto getSeller() {
        return seller;
    }

    public void setSeller(VendorWithLinksDto seller) {
        this.seller = seller;
    }

    public List<String> getSupplierContractFlags() {
        return supplierContractFlags;
    }

    public void setSupplierContractFlags(List<String> supplierContractFlags) {
        this.supplierContractFlags = supplierContractFlags;
    }

    public List<String> getSellerContractFlags() {
        return sellerContractFlags;
    }

    public void setSellerContractFlags(List<String> sellerContractFlags) {
        this.sellerContractFlags = sellerContractFlags;
    }

    @JsonIgnore
    public BookingAnswerDto getAnswer(String type) {
        for (BookingAnswerDto a : getAnswers()) {
            if( a.getType().equals(type) ) {
                return a;
            }
        }
        return null;
    }

    @JsonIgnore
    public List<BookingAnswerDto> getAnswers(String type) {
        List<BookingAnswerDto> list = new ArrayList<>();
        for (BookingAnswerDto a : getAnswers()) {
            if( a.getType().equals(type) ) {
                list.add(a);
            }
        }
        return list;
    }

    public Double getSavedAmount() {
        if ( totalPrice == null) {
            return 0d;
        }
        if ( priceWithDiscount == null ) {
            return totalPrice;
        }
        return totalPrice - priceWithDiscount;
    }

    @JsonIgnore
    public Double getPaidAmount() {
        double paidAmount = 0;
        for (SettlementDto p : invoice.settlements) {
            if ( p.getAmount() != null ) {
                paidAmount += p.getAmount();
            }
        }
        return paidAmount;
    }

    public String getBarcodeUrl() {
        return barcodeUrl;
    }

    public void setBarcodeUrl(String barcodeUrl) {
        this.barcodeUrl = barcodeUrl;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public String getCancelNote() {
        return cancelNote;
    }

    public void setCancelNote(String cancelNote) {
        this.cancelNote = cancelNote;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }
}
