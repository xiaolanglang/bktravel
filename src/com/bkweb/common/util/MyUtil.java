package com.bkweb.common.util;

public class MyUtil {

	/**
	 * 如果是空，就返回false，否则就返回true
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isEmpty(String str) {
		if ("".equals(str) || str == null) {
			return false;
		}
		return true;
	}
}
