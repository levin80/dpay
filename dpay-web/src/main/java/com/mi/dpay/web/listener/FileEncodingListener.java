package com.mi.dpay.web.listener;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 设置默认的文件编码
 * @author 李晓伟 (xwlig@isoftstone.com) <p>	iSoftStone</p>
 * @version 1.0 2015-3-4 下午4:26:17 
 */

public class FileEncodingListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		Properties prop = System.getProperties();
		prop.put("file.encoding", "utf-8");

	}

}