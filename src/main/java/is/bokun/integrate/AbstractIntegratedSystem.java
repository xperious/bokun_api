package is.bokun.integrate;

import java.util.*;

public abstract class AbstractIntegratedSystem implements IntegratedSystem {

	
	@Override
	public boolean isProductSupplier() {
		return false;
	}

	@Override
	public ProductSupplierCapabilities getProductSupplierCapabilities() {
		return null;
	}

	@Override
	public boolean isBookingConsumer() {
		return false;
	}

	@Override
	public List<IntegrationConfigParam> getConfigurationParams() {
		return new ArrayList<>();
	}

	@Override
	public ProductSupplier getProductSupplier(IntegrationConfig config) {
		return null;
	}

	@Override
	public BookingConsumer getBookingConsumer(IntegrationConfig config) {
		return null;
	}

	
}
