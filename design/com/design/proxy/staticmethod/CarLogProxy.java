package com.design.proxy.staticmethod;

public class CarLogProxy implements Moveable {

	private Moveable moveable;

	public CarLogProxy(Moveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void move() {
		System.out.println("....car log start");
		moveable.move();
		System.out.println("....car log end");
	}

}
