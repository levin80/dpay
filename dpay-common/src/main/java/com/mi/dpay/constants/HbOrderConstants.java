package com.mi.dpay.constants;
/**  
 * 订单信息常量
 * </p>Copyright(c) 2015 iSoftStone</p>
 * @author 李晓伟 (xwlig@isoftstone.com)
 * @filename: HbAccUserConstants.java
 * @version 1.0 2015-7-17 上午9:41:27 
 */
public final class HbOrderConstants {
	
	/**
	 * Description:订单付款状态
	 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
	 * @version 1.0 2015-7-17 上午9:48:37 
	 */
	
	public interface IsPaidConstant {
		public static final int PAY_WAIT          = 0;   //未付款(待付款)
		public static final int PAY_SUCC          = 1;   //已付款(付款成功)
		public static final int PAY_FLASE         = 2;   //已付款(付款失败)
		public static final int PAY_CLOSE         = 3;   //关闭， 未支付过有效期后由调度变更状态为关闭
	}
	
	/**
	 * Description:订单状态常量
	 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
	 * @version 1.0 2015-7-19 下午2:29:11 
	 */
	
	public interface OrderStateConstant {
		/*已取消*/
		public static final int ORDER0 = 0;
		/*创建订单，未支付 */
		public static final int ORDER1 = 1;
		/*已发起支付 、支付成功*/
		public static final int ORDER2 = 2;
		/*已发起支付 、支付失败*/
		public static final int ORDER3 = 3;
		/*已支付待退款*/
		public static final int ORDER4 = 4;
		/*未发货已退款*/
		public static final int ORDER5 = 5;
		/*已发货*/
		public static final int ORDER6 = 6;
		/*已收货*/
		public static final int ORDER7 = 7;
		/*买家已评价*/
		public static final int ORDER8 = 8;
		/*已互评（卖家评价）*/
		public static final int ORDER9 = 9;
		/*退货待退款中*/
		public static final int ORDER10 = 10;
		/*已退款*/
		public static final int ORDER11 = 11;
		/*已完成*/
		public static final int ORDER12 = 12;
		/*已失效 -未支付订单已过有效期*/
		public static final int ORDER13 = 13;
	}
   
	
	/**
	 * Description:快递常量
	 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
	 * @version 1.0 2015-7-19 下午2:30:30 
	 */
	
	public interface DeliveryConstant {
		
		/*快递运输*/
		public static final int DELIVERY_EMS=1;
		
	}
}
