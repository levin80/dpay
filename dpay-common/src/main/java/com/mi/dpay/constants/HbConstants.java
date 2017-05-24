package com.mi.dpay.constants;

public final class HbConstants {

	/**
	 * 前缀用于将来多的话做区分
	 */
	public final static String PREFF="";
	public final static String USER_KEY=PREFF+"user";
	public final static String VERIFY_SESSION_KEY=PREFF+"verify_code";
	/**
	 * 登录类型_移动用户 
	 */
	public static final int LOGIN_TYPE_MOBILE = 1;
	/**
	 * 登录类型_普通用户
	 */
	public static final int LOGIN_TYPE_NORMAL = 2;
	/**
	 * 密码类型_服务密码
	 */
	public static final int PASS_TYPE_SERVICE = 1;
	/**
	 * 密码类型_随机短信
	 */
	public static final int PASS_TYPE_RANDOM = 2;
	
	/**
	 * 现金账本
	 */
	public static final String ACC_TYPE_CASH  = "CASH";
	
	/**
	 *优惠账本
	 */
	public static final String ACC_TYPE_FAVOUR  = "FAVOUR";
	/**
	 * 前台充值
	 */
	public final static String WAY_PORTAL_CHARGE   = "3";
	/**
	 * 前台缴费
	 */
	public final static String WAY_PORTAL_PAY   = "2";
	
	
	
	/*类型*/
	public final static int TYPE_RECHARGE   = 1; //1 -充值
	public final static int TYPE_PAYFEE     = 2; //2 -扣费
	public final static int TYPE_REFUND     = 3; //3 -冲正
}
