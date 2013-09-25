package is.bokun.queries;

import java.util.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductFilter {

	public Long owningVendorId;
	public Set<String> owningVendorCategories = new HashSet<>();
	public Map<Long,VendorFilter> vendorFilters = new HashMap<>();
	
	public boolean isEmpty() {
		return vendorFilters.isEmpty();
	}
	
	public boolean isVendorAllowed(Long vendorId) {
		if ( owningVendorId.equals(vendorId) ) {
			return true;
		}		
		for (ProductFilter.VendorFilter v : vendorFilters.values()) {
			if ( v.vendorId.equals(vendorId) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isAllowed(Long productVendorId, Long productGroupId, String productCategory) {
		if ( owningVendorId.equals(productVendorId) ) {
			return true;
		}
		for (ProductFilter.VendorFilter v : vendorFilters.values()) {
			if ( v.vendorId.equals(productVendorId) ) {
				if ( v.productCategories.contains(productCategory) ) {
					return true;
				}
				if ( v.productGroupIds.contains(productGroupId) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	public VendorFilter getVendor(Long id) {
		if ( !vendorFilters.containsKey(id) ) {
			VendorFilter v = new VendorFilter();
			v.vendorId = id;
			vendorFilters.put(id, v);
		}
		return vendorFilters.get(id);
	}
	
	public static class VendorFilter {
		public Long vendorId;
		public Set<String> productCategories = new HashSet<>();
		public Set<Long> productGroupIds = new HashSet<>();
	}
}
