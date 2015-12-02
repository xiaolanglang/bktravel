package com.design.chainofresponsibility;

import java.util.Random;

public class TestMain {

	public static void main(String[] args) {
		PriceHandler handler = PriceHandelFactory.createPriceHandel();
		Random random = new Random();
		Customer customer = new Customer();
		customer.setHandler(handler);
		for (int i = 0; i < 100; i++) {
			System.out.println(i + 1 + ":");
			customer.requestDiscount(random.nextFloat());
		}
	}
}
