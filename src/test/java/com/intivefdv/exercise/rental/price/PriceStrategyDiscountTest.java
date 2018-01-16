package com.intivefdv.exercise.rental.price;

import org.junit.Assert;
import org.junit.Test;

public class PriceStrategyDiscountTest {

	@Test
	public void getPriceTest() {
		double discount = 0.5;
		double total = 100;
		PriceStrategy priceStrategy = new PriceStrategyDiscount(discount);
		Assert.assertEquals(total * discount, priceStrategy.getPrice(total), 0);
	}
}
