package com.design.tactics;

import com.design.tactics.impl.FlyWithWin;

public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		super();
		super.setFlyIf(new FlyWithWin());
	}

	@Override
	protected void display() {
		System.out.println("我是红头鸭");
	}

}
