package com.intivefdv.exercise.rental;

import org.junit.Assert;
import org.junit.Test;

import com.intivefdv.exercise.rental.price.PriceStrategy;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;
import com.intivefdv.exercise.rental.rentable.Bike;

public class RentByDayTest {

	@Test
	public void calcTotal() {
		Bike bike = new Bike();
		bike.setBikeId(1000L);
		int days = 10;
		RentalByDay rental = new RentalByDay(days, bike);
		PriceStrategy priceStrategy = new PriceStrategyNormal();
		Assert.assertEquals(priceStrategy.getPrice(days*bike.getPriceByDay()), rental.calcTotal(), 0);
	}
}
