package com.design.templete;

public class Coffe extends MakeDrinking {

	@Override
	protected void brew() {
		System.out.println("...这是一杯咖啡，用90度的水，泡匀");
	}

	@Override
	protected void addFlavorings() {
		System.out.println("...加入牛奶和糖");
	}

}
