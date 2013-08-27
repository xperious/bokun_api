package is.bokun.integrate;

import java.util.*;

public interface ProductSupplier {

	public ProductDescription findProductById(String id);
	
	public List<ProductDescription> findProductByTitle(String title);
	
	public void supplyAvailabilities(AvailabilityQuery query, AvailabilityConsumer consumer);

}
