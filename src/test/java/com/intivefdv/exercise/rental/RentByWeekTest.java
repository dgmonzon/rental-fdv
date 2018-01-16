package com.intivefdv.exercise.rental;

import org.junit.Assert;
import org.junit.Test;

import com.intivefdv.exercise.rental.price.PriceStrategy;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;
import com.intivefdv.exercise.rental.rentable.Bike;

public class RentByWeekTest {

	@Test
	public void calcTotal() {
		Bike bike = new Bike();
		bike.setBikeId(1000L);
		int weeks = 2;
		RentalByWeek rental = new RentalByWeek(weeks, bike);
		PriceStrategy priceStrategy = new PriceStrategyNormal();
		Assert.assertEquals(priceStrategy.getPrice(weeks*bike.getPriceByWeek()), rental.calcTotal(), 0);
	}
}
