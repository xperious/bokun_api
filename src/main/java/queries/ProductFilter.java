package queries;

import java.util.*;

public class ProductFilter {

	public Long owningVendorId;
	public Map<Long,VendorFilter> vendorFilters = new HashMap<>();
	
	public boolean isEmpty() {
		return vendorFilters.isEmpty();
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
