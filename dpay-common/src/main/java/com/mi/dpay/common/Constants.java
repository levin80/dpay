package com.mi.dpay.common;


/**
 * Constant values used throughout the application.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public final class Constants {

    private Constants() {
        // hide me
    }

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";


   
    public static final String CODE_URL = "/clouds/res/code/twoDimensionCode";  //验证码生成路径
    
    
    
    public static final String USER_STATUS_ACTIVE="0";  //激活
    public static final String USER_STATUS_UNACTIVE="1";  //未激活
    public static final String USER_STATUS_STOP="2";  //暂停
    public static final String USER_STATUS_OFF="3";  //注销
}
