package com.intivefdv.exercise.rental;

import org.junit.Assert;
import org.junit.Test;

import com.intivefdv.exercise.rental.price.PriceStrategy;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;
import com.intivefdv.exercise.rental.rentable.Bike;

public class RentByHourTest {

	@Test
	public void calcTotal() {
		Bike bike = new Bike();
		bike.setBikeId(1000L);
		int hours = 5;
		RentalByHour rental = new RentalByHour(hours, bike);
		PriceStrategy priceStrategy = new PriceStrategyNormal();
		Assert.assertEquals(priceStrategy.getPrice(hours*bike.getPriceByHour()), rental.calcTotal(), 0);
	}
}
