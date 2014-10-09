package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import is.bokun.dtos.booking.BookingRoleEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductBookingQuery {

    /**
     * Number of the page to retrieve in the paginated result list.
     * Default value is 1.
     */
    public int page = 1;
    /**
     * Number of result on each page in the paginated result list.
     * Default value is 50.
     */
    public int pageSize = 50;

    public String confirmationCode;
    public String productType;

    public String textFilter;

    public String productTitle;
    public String productExternalId;
    public String noteQuery;

    public BookingRoleEnum bookingRole;

    public Map<String,Object> fields;

    public List<SortField> sortFields;

    public List<String> bookingStatuses;

    public List<Long> bookedExtrasIds;

    public DateRangeFilter creationDateRange;
    public DateRangeFilter startDateRange;

    public List<Long> productIds;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public BookingRoleEnum getBookingRole() {
        return bookingRole;
    }

    public void setBookingRole(BookingRoleEnum bookingRole) {
        this.bookingRole = bookingRole;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductExternalId() {
        return productExternalId;
    }

    public void setProductExternalId(String productExternalId) {
        this.productExternalId = productExternalId;
    }

    public String getNoteQuery() {
        return noteQuery;
    }

    public void setNoteQuery(String noteQuery) {
        this.noteQuery = noteQuery;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public List<SortField> getSortFields() {
        return sortFields;
    }

    public void setSortFields(List<SortField> sortFields) {
        this.sortFields = sortFields;
    }

    public List<String> getBookingStatuses() {
        return bookingStatuses;
    }

    public void setBookingStatuses(List<String> bookingStatuses) {
        this.bookingStatuses = bookingStatuses;
    }

    public List<Long> getBookedExtrasIds() {
        return bookedExtrasIds;
    }

    public void setBookedExtrasIds(List<Long> bookedExtrasIds) {
        this.bookedExtrasIds = bookedExtrasIds;
    }

    public DateRangeFilter getCreationDateRange() {
        return creationDateRange;
    }

    public void setCreationDateRange(DateRangeFilter creationDateRange) {
        this.creationDateRange = creationDateRange;
    }

    public DateRangeFilter getStartDateRange() {
        return startDateRange;
    }

    public void setStartDateRange(DateRangeFilter startDateRange) {
        this.startDateRange = startDateRange;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
