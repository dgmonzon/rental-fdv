package com.intivefdv.exercise.rental.rentable;

public class Bike implements Rentable {

	private Long bikeId;
	
	public void setBikeId(Long bikeId) {
		this.bikeId = bikeId;
	}
	
	public Long getBikeId() {
		return bikeId;
	}
	
	@Override
	public double getPriceByHour() {
		return 5;
	}

	@Override
	public double getPriceByDay() {
		return 20;
	}

	@Override
	public double getPriceByWeek() {
		return 60;
	}
	
}
