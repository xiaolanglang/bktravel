package com.design.adapter;

public class NetBook {
	private ThreePlugIf plug;

	public NetBook(ThreePlugIf plug) {
		this.plug = plug;
	}

	public void charge() {
		plug.powerWithThree();
	}
}
