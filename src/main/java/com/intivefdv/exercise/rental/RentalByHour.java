package com.intivefdv.exercise.rental;

import com.intivefdv.exercise.rental.rentable.Rentable;

public class RentalByHour extends Rental {

	private int hours;
	private Rentable rentable;
	
	public RentalByHour(int hours, Rentable rentable) {
		this.hours = hours;
		this.rentable = rentable;
	}
	
	@Override
	public double calcTotal() {
		return getPriceStrategy().getPrice(hours*rentable.getPriceByHour());
	}
	
}
