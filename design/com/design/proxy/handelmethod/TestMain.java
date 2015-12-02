package com.design.proxy.handelmethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.design.proxy.staticmethod.Car;
import com.design.proxy.staticmethod.Moveable;

public class TestMain {

	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler handler = new TimeHandelProxy(car);
		Moveable moveable = (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(),
				handler);
		moveable.move();

	}

}
