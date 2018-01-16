package com.intivefdv.exercise.rental.price;

import org.junit.Assert;
import org.junit.Test;

public class PriceStrategyNormalTest {

	@Test
	public void getPriceTest() {
		double total = 100;
		PriceStrategy priceStrategy = new PriceStrategyNormal();
		Assert.assertEquals(total, priceStrategy.getPrice(total), 0);
	}
}
