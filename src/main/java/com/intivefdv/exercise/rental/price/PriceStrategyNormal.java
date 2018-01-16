package com.intivefdv.exercise.rental.price;

public class PriceStrategyNormal implements PriceStrategy {

	@Override
	public double getPrice(double total) {
		return total;
	}

}
