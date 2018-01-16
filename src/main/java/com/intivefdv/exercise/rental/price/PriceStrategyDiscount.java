package com.intivefdv.exercise.rental.price;

public class PriceStrategyDiscount implements PriceStrategy {

	private double quantityDiscount;
	
	public PriceStrategyDiscount(double discount) {
		quantityDiscount = discount;
	}
	
	@Override
	public double getPrice(double total) {
		return total - (quantityDiscount * total);
	}

}
