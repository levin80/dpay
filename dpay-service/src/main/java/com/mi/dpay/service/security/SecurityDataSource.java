package com.mi.dpay.service.security;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.mi.dpay.common.DesUtil;

/**
 * 重写apache包中dbcp里datasource，通过中间处理加入des的密码加解密机制
 * 
 * @author majun
 *
 */
public class SecurityDataSource extends BasicDataSource {
	
	private static final Logger log = Logger.getLogger(SecurityDataSource.class);

	public SecurityDataSource() {
		
	}
	
	public void setUsername(String username) {
		try {
			username = DesUtil.decrypt(username, DesUtil.KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("security datasource decrypt username error: ", e);
			super.setUsername("admin");
			return;
		}
		super.setUsername(username);
	}
	
	public void setPassword(String password) {
		try {
			password = DesUtil.decrypt(password, DesUtil.KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("security datasource decrypt password error: ", e);
			super.setPassword("admin");
			return;
		}
		super.setPassword(password);
	}
	
	public synchronized void close() throws SQLException {
		DriverManager.deregisterDriver(DriverManager.getDriver(url));
		super.close();
	}
	
}
