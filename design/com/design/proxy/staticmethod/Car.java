package com.design.proxy.staticmethod;

public class Car implements Moveable {

	@Override
	public void move() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(".............run");
	}

}
