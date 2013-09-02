package is.bokun.integrate;

import java.util.*;

public interface ProductSupplier {
	
	public List<ProductDescription> findProductByTitle(String title);
	
	public void supplyAvailabilities(AvailabilityQuery query, AvailabilityConsumer consumer);

}
