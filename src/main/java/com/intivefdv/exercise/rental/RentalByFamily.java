package com.intivefdv.exercise.rental;

import java.util.ArrayList;
import java.util.List;

import com.intivefdv.exercise.rental.price.PriceStrategyDiscount;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;

public class RentalByFamily extends Rental {

	private List<Rental> rentals;
	private static final int MIN_Q = 3;
	private static final int MAX_Q = 5;
	static final double DISCOUNT = 0.3;
	
	public RentalByFamily() {
		rentals = new ArrayList<>();
	}
	
	@Override
	public double calcTotal() {
		double total = 0;
		for (Rental r : rentals) {
			total = total + r.calcTotal();
		}
		return getPriceStrategy().getPrice(total);
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
		if (rentals.size() >= MIN_Q && rentals.size() <= MAX_Q) {
			setPriceStrategy(new PriceStrategyDiscount(DISCOUNT));
		} else {
			setPriceStrategy(new PriceStrategyNormal());
		}
	}
	
}       