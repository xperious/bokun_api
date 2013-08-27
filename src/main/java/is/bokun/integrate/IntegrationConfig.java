package is.bokun.integrate;

public interface IntegrationConfig {

	public String get(String name);
	public String get(String name, String defaultValue);
	
	public int getInt(String name);
	public int getInt(String name, int defaultValue);
	
	public double getDouble(String name);
	public double getDouble(String name, double defaultValue);
	
	public boolean getBoolean(String name);
	public boolean getBoolean(String name, boolean defaultValue);
}
