package is.bokun.dtos.pricing;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import static is.bokun.utils.PriceUtils.calculatePriceWithDiscount;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlType(name = "PriceModulationOutput")
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceModulationOutput {

	public boolean foundPrice;

    public double unModulatedPrice;
	public double price;
	public double discount;
	public double discountAmount;
	public String currency;

	public List<PriceModulatorConfigDto> appliedModulators;

    public PriceModulationOutput() {}

	public PriceModulationOutput(boolean b, String currency) {
		foundPrice = b;
		appliedModulators = Collections.emptyList();
		unModulatedPrice = Double.NaN;
		price = Double.NaN;
		discount = 0;
		discountAmount = 0;
		this.currency = currency;
	}

	public PriceModulationOutput(double price, double modulatedPrice, String currency, double discount, double discountAmount, List<PriceModulatorConfigDto> appliedModulators) {
		this.foundPrice = true;
		this.unModulatedPrice = price;
		this.price = modulatedPrice;
		this.discount = discount;
		this.discountAmount = discountAmount;
		this.appliedModulators = appliedModulators;
		this.currency = currency;
	}

	public double getPriceWithDiscount(){
		Preconditions.checkArgument(foundPrice, "No price found");
		return calculatePriceWithDiscount(price, discount, discountAmount);
	}

}
