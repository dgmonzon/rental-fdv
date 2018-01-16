package com.intivefdv.exercise.rental;

import com.intivefdv.exercise.rental.rentable.Rentable;

public class RentalByWeek extends Rental {

	private Rentable rentable;
	private int weeks;
	
	public RentalByWeek(int weeks, Rentable rentable) {
		this.weeks = weeks;
		this.rentable = rentable;
	}
	
	@Override
	public double calcTotal() {
		return getPriceStrategy().getPrice(weeks*rentable.getPriceByWeek());
	}

}
