package dtos;

import com.codiform.moo.annotation.Property;

public class WidgetSettingsDto {
	
	@Property(translate = true)
	public FacebookWidgetSettingsDto facebookWidget;
	
	@Property(translate = true)
	public TwitterWidgetSettingsDto twitterWidget;
	
	@Property(translate = true)
	public TripadvisorWidgetSettingsDto tripadvisorWidget;
}
