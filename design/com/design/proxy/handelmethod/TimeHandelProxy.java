package com.design.proxy.handelmethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandelProxy implements InvocationHandler {

	private Object proxyObj;

	public TimeHandelProxy(Object proxyObj) {
		this.proxyObj = proxyObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(">>>>>>>log start");
		method.invoke(proxyObj, args);
		System.out.println(">>>>>>>log end");
		return null;
	}

}
