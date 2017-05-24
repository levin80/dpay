package com.mi.dpay.beans;

import java.util.UUID;

/**  
 * </p>  Copyright(c) 2015 iSoftStone  </p>
 * @filename: BaseBean.java
 * @version 1.0 2015-3-16 下午3:51:15 
 */
public class BaseBean {
	
	/**
	 * Description:UUID
	 * @version 1.0 2015-3-16 下午3:52:25 
	 * @return 
	 * String
	 */
	public static String getID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
