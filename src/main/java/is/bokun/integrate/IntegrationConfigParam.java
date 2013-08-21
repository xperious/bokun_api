package is.bokun.integrate;

import java.util.*;

public class IntegrationConfigParam {

	public static enum ParamType {
		STRING,INT,DOUBLE,BOOLEAN,DATE,DATE_AND_TIME,SELECT_ONE;
	}
	
	public static class ParameterOption {
		public String name, value;
		
		public ParameterOption() {}
		
		public ParameterOption(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
		public ParameterOption(String value) {
			this(value, value);
		}
	}
		
	public String name;
	public ParamType paramType;
	public boolean required;
	public String defaultValue;
	public List<ParameterOption> options = new ArrayList<>();
	public String widgetType;
	
	public IntegrationConfigParam() {}
	
	public IntegrationConfigParam(String name, ParamType paramType, boolean required) {
		this(name, paramType, required, null);
	}
	
	public IntegrationConfigParam(String name, ParamType paramType, boolean required, String defaultValue) {
		this.name = name;
		this.paramType = paramType;
		this.defaultValue = defaultValue;
		this.required = required;
	}
		
}
