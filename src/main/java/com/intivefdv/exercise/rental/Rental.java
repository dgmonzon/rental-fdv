package com.intivefdv.exercise.rental;

import com.intivefdv.exercise.rental.price.PriceStrategy;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;

public abstract class Rental {

	private PriceStrategy priceStrategy;

	public Rental() {
		this.priceStrategy = new PriceStrategyNormal();
	}
	
	public abstract double calcTotal();
	
	public void setPriceStrategy(PriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}
	
	public PriceStrategy getPriceStrategy() {
		return priceStrategy;
	}
	
}
