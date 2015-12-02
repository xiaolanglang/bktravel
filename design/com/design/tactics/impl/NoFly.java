package com.design.tactics.impl;

import com.design.tactics.FlyIf;


public class NoFly implements FlyIf{

	@Override
	public void fly() {
		System.out.println("这是一只不会飞行的鸭子");
	}

}
