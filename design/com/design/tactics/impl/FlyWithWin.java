package com.design.tactics.impl;

import com.design.tactics.FlyIf;


public class FlyWithWin implements FlyIf{

	@Override
	public void fly() {
		System.out.println("使用翅膀进行飞翔");
	}
}
