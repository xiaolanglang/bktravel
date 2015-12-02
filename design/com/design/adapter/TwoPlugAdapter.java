package com.design.adapter;

/**
 * 二向转三向插座
 * 
 * @author Administrator
 * 
 */
public class TwoPlugAdapter implements ThreePlugIf {

	private GBTwoPlug gbTwoPlug;

	public TwoPlugAdapter(GBTwoPlug gbTwoPlug) {
		this.gbTwoPlug = gbTwoPlug;
	}

	@Override
	public void powerWithThree() {
		System.out.print("通过转换，");
		gbTwoPlug.powerWithTwo();
	}

}
