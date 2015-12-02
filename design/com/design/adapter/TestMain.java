package com.design.adapter;

public class TestMain {
	public static void main(String[] args) {
		GBTwoPlug gbTwoPlug=new GBTwoPlug();
		ThreePlugIf plug=new TwoPlugAdapter(gbTwoPlug);
		NetBook book=new NetBook(plug);
		book.charge();
	}
}
