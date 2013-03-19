package is.bokun.queries;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Olafur Gauti Gudmundsson
 */
public class CustomerQuery {

    public String firstName;
    public String lastName;
    public String email;
    public String organization;

    public String sortField = "lastName";
    public boolean sortAsc = true;

    public Set<Long> vendorIds = new HashSet<>();

    public int pageNumber = 0;
    public int pageSize = 50;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Set<Long> getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(Set<Long> vendorIds) {
        this.vendorIds = vendorIds;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public boolean isSortAsc() {
        return sortAsc;
    }

    public void setSortAsc(boolean sortAsc) {
        this.sortAsc = sortAsc;
    }
}
