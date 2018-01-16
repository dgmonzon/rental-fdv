package com.intivefdv.exercise.rental;

import com.intivefdv.exercise.rental.rentable.Rentable;

public class RentalByDay extends Rental {

	private Rentable rentable;
	private int days;
	
	public RentalByDay(int days, Rentable rentable) {
		this.days = days;
		this.rentable = rentable;
	}
	
	@Override
	public double calcTotal() {
		return getPriceStrategy().getPrice(days*rentable.getPriceByDay());
	}
	
}
