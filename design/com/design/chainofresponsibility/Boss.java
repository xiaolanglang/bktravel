package com.design.chainofresponsibility;

public class Boss extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if (discount < 0.55) {
			System.out.format("%s批准了折扣:%.2f%n", this.getClass().getName(), discount);
		}else{
			System.out.format("%s拒绝   了折扣:%.2f%n", this.getClass().getName(), discount);;
		}
	}

}
