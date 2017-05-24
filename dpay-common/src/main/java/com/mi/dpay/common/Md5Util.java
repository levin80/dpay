package com.mi.dpay.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Md5Util {

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	
	private String inStr;
	private MessageDigest md5;
	
	
	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式为源md5比特
	public static byte[] hexStr2ByteArray(String hexStr) {
		hexStr = hexStr.toUpperCase();
		char[] data = hexStr.toCharArray();
		int len = data.length;

		byte[] out = new byte[len / 2];
		for (int i = 0; i < len; i = i + 2) {
			String strTmp = new String(data, i, 2);
			out[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return out;
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public final static String MD5String(String s) {

		String resultString = null;
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			resultString = byteToString(mdInst.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return resultString;
		}
		return resultString;
	}

	public final static byte[] MD5Byte(String s) {
		byte[] byt = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byt = md.digest(s.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byt;
	}

	public String encode(byte[] byt) {
		String s = "";
		try {
			BASE64Encoder be = new BASE64Encoder();
			if (byt != null) {
				s = be.encode(byt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public String encode(String s) {
		String encode = "";
		try {
			BASE64Encoder be = new BASE64Encoder();
			if (s != null) {
				encode = be.encode(s.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encode;
	}

	public String decode(String s) {
		String decode = "";
		try {
			BASE64Decoder bd = new BASE64Decoder();
			if (s != null) {
				byte[] byt = bd.decodeBuffer(s);
				decode = byteToString(byt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decode;
	}

	/**
	 * 将源字符串使用MD5加密为字节数组
	 * 
	 * @param source
	 * @return
	 */
	public static byte[] encode2bytes(String source) {
		byte[] result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(source.getBytes("UTF-8"));
			result = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Md5Util(String inStr) {
		this.inStr = inStr;
		try {
			this.md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Computes the MD5 fingerprint of a string.
	 * 
	 * @return the MD5 digest of the input <code>String</code>
	 */
	public String compute() {
		// convert input String to a char[]
		// convert that char[] to byte[]
		// get the md5 digest as byte[]
		// bit-wise AND that byte[] with 0xff
		// prepend "0" to the output StringBuffer to make sure that we don't end
		// up with
		// something like "e21ff" instead of "e201ff"

		char[] charArray = this.inStr.toCharArray();

		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = this.md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	public static void main(String[] args) {
		Md5Util md5 = new Md5Util("11111111");
		String postString = md5.compute().toUpperCase();
		System.out.println(postString);
		if (postString.equals("E10ADC3949BA59ABBE56E057F20F883E")) {
			System.out.println("true");
		} else
			System.out.println("false");
	}
}
