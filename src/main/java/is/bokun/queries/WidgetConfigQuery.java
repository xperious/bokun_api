package is.bokun.queries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetConfigQuery {

	public String widgetTitle;
	public String widgetType;
	public String vendorTitle;
	public Long vendorId;
	
	public String getWidgetTitle() {
		return widgetTitle;
	}
	public void setWidgetTitle(String widgetTitle) {
		this.widgetTitle = widgetTitle;
	}
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public String getVendorTitle() {
		return vendorTitle;
	}
	public void setVendorTitle(String vendorTitle) {
		this.vendorTitle = vendorTitle;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
}
