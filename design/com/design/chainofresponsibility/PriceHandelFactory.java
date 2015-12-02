package com.design.chainofresponsibility;

public class PriceHandelFactory {
	public static PriceHandler createPriceHandel() {
		PriceHandler sales = new Sales();
		PriceHandler manager = new Manager();
		PriceHandler ceo = new CEO();
		PriceHandler boss = new Boss();
		
		sales.setHandler(manager);
		manager.setHandler(ceo);
		ceo.setHandler(boss);

		return sales;
	}
}
