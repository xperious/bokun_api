package is.bokun.integrate;

import is.bokun.dtos.ProductCategoryEnum;

import java.util.*;

public class ProductSupplierCapabilities {

	private final Set<ProductCategoryEnum> supportedProductCategories;
	private final boolean suppliesProductInfo;
	private final boolean suppliesAvailabilityAndPricing;
	
	public ProductSupplierCapabilities(boolean suppliesProductInfo, boolean suppliesAvailabilityAndPricing, ProductCategoryEnum...productCategories) {
		this.suppliesProductInfo = suppliesProductInfo;
		this.suppliesAvailabilityAndPricing = suppliesAvailabilityAndPricing;
		this.supportedProductCategories = new HashSet<>();
		for (ProductCategoryEnum cat : productCategories) {
			supportedProductCategories.add(cat);
		}
	}

	public Set<ProductCategoryEnum> getSupportedProductCategories() {
		return Collections.unmodifiableSet(supportedProductCategories);
	}
	
	public boolean supports(ProductCategoryEnum cat) {
		return supportedProductCategories.contains(cat);
	}

	public boolean isSuppliesProductInfo() {
		return suppliesProductInfo;
	}

	public boolean isSuppliesAvailabilityAndPricing() {
		return suppliesAvailabilityAndPricing;
	}
	
}
