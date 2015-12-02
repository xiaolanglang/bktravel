package com.design.proxy.staticmethod;

public class CarTimeProxy implements Moveable {

	private Moveable moveable;

	public CarTimeProxy(Moveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void move() {
		System.out.println("....car time start");
		long startTime = System.currentTimeMillis();
		moveable.move();
		long endTime = System.currentTimeMillis();
		System.out.println("....car time end and time is " + (endTime - startTime) + "ms");
	}

}
