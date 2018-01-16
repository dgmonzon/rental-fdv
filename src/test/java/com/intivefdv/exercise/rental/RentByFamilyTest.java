package com.intivefdv.exercise.rental;

import org.junit.Assert;
import org.junit.Test;

import com.intivefdv.exercise.rental.price.PriceStrategy;
import com.intivefdv.exercise.rental.price.PriceStrategyDiscount;
import com.intivefdv.exercise.rental.price.PriceStrategyNormal;
import com.intivefdv.exercise.rental.rentable.Bike;

public class RentByFamilyTest {

	@Test
	public void calcTotalWithDiscount() {
		Long bikeId1 = 1001L;
		Long bikeId2 = 1002L;
		Long bikeId3 = 1003L;
		Long bikeId4 = 1004L;
		int hours = 6;
		RentalByFamily rentByFamily = new RentalByFamily();
		Rental r1 = createBikeRentalByHours(bikeId1, hours);
		rentByFamily.addRental(r1);
		Rental r2 = createBikeRentalByHours(bikeId2, hours);
		rentByFamily.addRental(r2);
		Rental r3 = createBikeRentalByHours(bikeId3, hours);
		rentByFamily.addRental(r3);
		Rental r4 = createBikeRentalByHours(bikeId4, hours);
		rentByFamily.addRental(r4);
		PriceStrategy priceStrategy = new PriceStrategyDiscount(RentalByFamily.DISCOUNT);
		double total = r1.calcTotal() + r2.calcTotal() + r3.calcTotal() + r4.calcTotal();
		Assert.assertEquals(priceStrategy.getPrice(total), rentByFamily.calcTotal(), 0);
	}
	
	@Test
	public void calcTotalWithoutDiscount() {
		Long bikeId1 = 1001L;
		Long bikeId2 = 1002L;
		int hours = 6;
		RentalByFamily rentByFamily = new RentalByFamily();
		Rental r1 = createBikeRentalByHours(bikeId1, hours);
		rentByFamily.addRental(r1);
		Rental r2 = createBikeRentalByHours(bikeId2, hours);
		rentByFamily.addRental(r2);
		double total = r1.calcTotal() + r2.calcTotal();
		PriceStrategy priceStrategy = new PriceStrategyNormal();
		Assert.assertEquals(priceStrategy.getPrice(total), rentByFamily.calcTotal(), 0);
	}
	
	@Test
	public void calcTotalWithMultipleRents() {
		Long bikeId1 = 1001L;
		Long bikeId2 = 1002L;
		Long bikeId3 = 1003L;
		Long bikeId4 = 1004L;
		int hours = 6;
		int days = 4;
		int weeks = 1;
		RentalByFamily rentByFamily = new RentalByFamily();
		Rental r1 = createBikeRentalByHours(bikeId1, hours);
		rentByFamily.addRental(r1);
		Rental r2 = createBikeRentalByDays(bikeId2, days);
		rentByFamily.addRental(r2);
		Rental r3 = createBikeRentalByWeeks(bikeId3, weeks);
		rentByFamily.addRental(r3);
		Rental r4 = createBikeRentalByWeeks(bikeId4, weeks);
		rentByFamily.addRental(r4);
		double total = r1.calcTotal() + r2.calcTotal() + r3.calcTotal() + r4.calcTotal();
		PriceStrategy priceStrategy = new PriceStrategyDiscount(RentalByFamily.DISCOUNT);
		Assert.assertEquals(priceStrategy.getPrice(total), rentByFamily.calcTotal(), 0);
	}
	
	private Rental createBikeRentalByHours(Long bikeId, int hours) {
		Bike bike = new Bike();
		bike.setBikeId(bikeId);
		return new RentalByHour(hours, bike);
	}
	
	private Rental createBikeRentalByDays(Long bikeId, int days) {
		Bike bike = new Bike();
		bike.setBikeId(bikeId);
		return new RentalByDay(days, bike);
	}
	
	private Rental createBikeRentalByWeeks(Long bikeId, int weeks) {
		Bike bike = new Bike();
		bike.setBikeId(bikeId);
		return new RentalByWeek(weeks, bike);
	}
}
