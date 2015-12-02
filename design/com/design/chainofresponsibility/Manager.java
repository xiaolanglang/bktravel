package com.design.chainofresponsibility;

public class Manager extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount < 0.2) {
			System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
		}else{
			handler.processDiscount(discount);
		}
	}

}
