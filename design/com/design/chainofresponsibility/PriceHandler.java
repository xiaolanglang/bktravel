package com.design.chainofresponsibility;

public abstract class PriceHandler {
	protected PriceHandler handler;

	protected void setHandler(PriceHandler handler) {
		this.handler = handler;
	}

	public abstract void processDiscount(float discount);
}
