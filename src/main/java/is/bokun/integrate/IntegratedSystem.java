package is.bokun.integrate;

import java.util.List;

public interface IntegratedSystem {
	
	public String getType();
	public List<IntegrationConfigParam> getConfigurationParams();

	public boolean isProductSupplier();
	public ProductSupplierCapabilities getProductSupplierCapabilities();
	public ProductSupplier getProductSupplier(IntegrationConfig config);
	
	public boolean isBookingConsumer();
	public BookingConsumer getBookingConsumer(IntegrationConfig config);
}
