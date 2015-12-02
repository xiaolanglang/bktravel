package com.design.templete;

public abstract class MakeDrinking {

	public final void makeFrink() {
		boilWarter();
		brew();
		pourIntoCup();
		addFlavorings();
	}

	private void boilWarter() {
		System.out.println("...把水煮沸");
	}

	private void pourIntoCup() {
		System.out.println("...倒进杯中");
	}

	/**
	 * 酝酿
	 */
	protected abstract void brew();

	/**
	 * 添加调味剂
	 */
	protected abstract void addFlavorings();
}
