package com.mi.dpay.service.security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.mi.dpay.common.Md5Util;

public class SecurityMD5Encoder implements PasswordEncoder {
	
	public String encodePassword(String origPwd, Object salt)
			throws DataAccessException {
		return Md5Util.MD5String(origPwd);
	}
	
	public boolean isPasswordValid(String encPwd, String origPwd, Object salt)
			throws DataAccessException {
		return encPwd.equals(encodePassword(origPwd, salt));
	}

	public static void main(String args[]) {
		SecurityMD5Encoder encoder = new SecurityMD5Encoder();
		System.out.println(encoder.encodePassword("passw0rd", null));
	}
}
