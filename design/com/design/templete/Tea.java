package com.design.templete;

public class Tea extends MakeDrinking {

	@Override
	protected void brew() {
		System.out.println("...这是一杯茶，用80度的水，冲泡5分钟");
	}

	@Override
	protected void addFlavorings() {
		System.out.println("...这是一杯茶，加入少许茉莉花");
	}

}
