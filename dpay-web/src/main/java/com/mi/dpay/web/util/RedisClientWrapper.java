package com.mi.dpay.web.util;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description:Redis client wrapper
 * @version 1.0 2015-7-30 下午5:29:32 
 */

public class RedisClientWrapper {

	private static final Log log = LogFactory.getLog(RedisClientWrapper.class);

	/**
	 * 默认的 Redis 缓存有效时间，当使用者不设置缓存时间时生效，目前暂定30分钟
	 */
	public final static int DEFAULT_CACHE_EXP_TIME = 30 * 60;

	/**
	 * 统一使用往cookie中存储的userkey
	 */
	public final static String REDIS_KEY="isoftstone";
	/**
	 * 统一使用往cookie中存储的user_ecps_key权限
	 */
	public final static String REDIS_HZCLOUDS_KEY=REDIS_KEY+".hzclouds";

	
	/**
	 * 生成全球唯一ID，通常用来做 Redis 的 Key 值使用，避免重复和与用户无关
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
