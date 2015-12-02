package com.design.proxy.staticmethod;

public class TestMain {

	public static void main(String[] args) {
		Car car = new Car();
		CarTimeProxy timeProxy = new CarTimeProxy(car);
		CarLogProxy logProxy = new CarLogProxy(timeProxy);
		logProxy.move();
	}

}
