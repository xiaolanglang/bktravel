package com.design.tactics;

public class TestMain {
	public static void main(String[] args) {
		Duck redHeadDuck = new RedHeadDuck();
		redHeadDuck.say();
		redHeadDuck.display();
		redHeadDuck.fly();
		System.out.println("===============");
		Duck bigYellowDuck=new BigYellowDuck();
		bigYellowDuck.say();
		bigYellowDuck.display();
		bigYellowDuck.fly();
	}
}
