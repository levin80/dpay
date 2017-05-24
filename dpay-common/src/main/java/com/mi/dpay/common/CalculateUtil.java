package com.mi.dpay.common;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculateUtil {
	public static final int  BASELINE = 100;//以100为单位
	
	public static final int  REAL_BASELINE = 10000;//以100000为单位
	
	
	
	/**
	 * 
	 * @param base
	 * @param amount
	 * @return
	 */
	public static final int calcRealRate(int baseReal,int rate) {
		BigDecimal i = new BigDecimal(baseReal);
		BigDecimal j = new BigDecimal(rate);
		BigDecimal d = new BigDecimal(BASELINE);
		BigDecimal fc = i.multiply(j).divide(d);
		
		return fc.intValue();
	}
	
	/**实际费率，小数
	 * @param base
	 * @param amount
	 * @return
	 */
	public static final BigDecimal calcRealFee(int base,int amount) {
		BigDecimal i = new BigDecimal(base);
		BigDecimal j = new BigDecimal(amount);
		BigDecimal d = new BigDecimal(REAL_BASELINE);
		BigDecimal fc = i.multiply(j).divide(d);
		return fc;
	}
	
	
	
	
	/**实际金额
	 *   保留2位小数，舍去第三位
	 * @param base
	 * @param amount
	 * @return
	 */
	public static final float calcRealMoney(int money ,int base,int amount) {
		BigDecimal f = calcRealFee(base,amount);
		BigDecimal bm = new BigDecimal(money);
		BigDecimal rm  = bm.multiply(f);
		float fl = rm.setScale(2, BigDecimal.ROUND_HALF_DOWN).floatValue();//保留2位小数
		return fl;
	}
	
	
	public static void main (String args []){
		int t = calcRealRate(1000,70);
		System.out.println(t);

		BigDecimal realFee = calcRealFee(7,50);
		System.out.println("实际费率为："+realFee);
		float rm = calcRealMoney(1,7,50);
		System.out.println("实际金额为："+ rm);

		
	}
}
