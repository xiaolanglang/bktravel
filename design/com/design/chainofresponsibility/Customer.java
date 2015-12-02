package com.design.chainofresponsibility;

public class Customer {
	private PriceHandler handler;

	public void setHandler(PriceHandler handler) {
		this.handler = handler;
	}

	public void requestDiscount(float discount) {
		handler.processDiscount(discount);
	}
}
