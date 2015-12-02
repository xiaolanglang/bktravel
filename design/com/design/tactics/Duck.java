package com.design.tactics;


public abstract class Duck {
	private FlyIf flyIf;

	protected void say() {
		System.out.println("嘎嘎嘎");
	}

	protected abstract void display();

	public void fly() {
		flyIf.fly();
	}

	public FlyIf getFlyIf() {
		return flyIf;
	}

	public void setFlyIf(FlyIf flyIf) {
		this.flyIf = flyIf;
	}

}
