package com.mi.dpay.common;

import java.util.Random;



public class CommUtil {
	/**
	 * Description:随机码
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2016-1-22 下午4:43:43 
	 * @param length
	 * @return 
	 * String
	 */
	public static final String randomInt(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = ("0123456789").toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}
	
	/**
	 * Description:
	 * @author 李晓伟 (xwlig@isoftstone.com)
	 * @version 1.0 2016-1-22 下午4:45:34 
	 * @param s
	 * @return 
	 * String
	 */
	public static String null2String(Object s) {
		return s == null ? "" : s.toString().trim();
	}
}
