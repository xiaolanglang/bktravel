package com.design.tactics;

import com.design.tactics.impl.NoFly;

public class BigYellowDuck extends Duck {

	public BigYellowDuck() {
		super.setFlyIf(new NoFly());
	}

	@Override
	protected void display() {
		System.out.println("我是大黄鸭，浑身是黄色的，拥有红色的嘴");
	}

}
