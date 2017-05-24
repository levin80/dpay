package com.mi.dpay.common;

import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.List;


/**
 * 字符串处理工具类
 * 
 */
public class StringUtil {

	public final static char[] filterChars = { ',', '，', ';', '；', '"', '“', '”', '‘', '’', '=', '(', ')', '[', ']', '，', '/', '@', '>', '<', '!', '&', '*', '^', '-', '+', '\'', '\\' };

	/**
	 * 判断字符串是否为null或者length为0
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (s == null)
			return true;
		if (s.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 判断字符串是否不为null或者length为0
	 * 
	 * @param s
	 * @return
	 */
	public static boolean notEmpty(String s) {
		return !isEmpty(s);
	}

	/**
	 * 将字符串s转换为integer类型，如果字符串为null返回defaultValue
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static int toInt(String s, int defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return new Integer(s).intValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * toInt的warper方法，如果字符串s为null将返回-1
	 * 
	 * @param s
	 * @return
	 */
	public static int toInt(String s) {
		return toInt(s, -1);
	}

	/**
	 * 将字符串s转换为Float类型，如果字符串为null返回defaultValue
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static float toFloat(String s, float defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return new Float(s).floatValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串s转换为Boolean类型，如果字符串为null返回defaultValue
	 * 
	 * @param s
	 * @param defaultValue
	 * @return
	 */
	public static boolean toBoolean(String s, boolean defaultValue) {
		if (s == null)
			return defaultValue;

		try {
			return Boolean.valueOf(s).booleanValue();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 把本地字符串转换成unicode或者ascii编码格式
	 * 
	 * @param text
	 * @return
	 */
	public static String native2ascii(String text) {
		if (text == null)
			return null;

		char[] myBuffer = text.toCharArray();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < myBuffer.length; i++) {
			char c = myBuffer[i];
			Character.UnicodeBlock ub = UnicodeBlock.of(c);

			if (ub == UnicodeBlock.BASIC_LATIN) {
				// 英文及数字等
				sb.append(c);
			} else {
				// 汉字
				String hexS = Integer.toHexString(c & 0xffff);
				sb.append("\\u").append(hexS.toLowerCase());
			}
		}
		return sb.toString();
	}

	public static String searchIn(String search) {
		if(!StringUtil.isEmpty(search)){
			search = search.replaceAll("/", "");
			search = search.replaceAll("%", "/%");
			search = search.replaceAll("_", "/_");
		}
		return search;
	}

	/**
	 * 搜索转义器，对要搜索的字符串进行转义，用'/'作为转义符,改方法可处理所有特殊字符的查询
	 * 
	 * @param search
	 * @return
	 */
	public static String searchConver(String search) {
		// 如果搜索包括转义符本身，则对自身进行转义，这样可以搜索转义符本身了
		search = search.replaceAll("/", "//");
		// 必需先对转义字符进行转义才能对其他字符进行转义，否则会出错，因为会那样会导致二次转义，会搜索出错误信息
		// 因为SQL查询中如果字符串中有单引号，要转换成两个单引号，如果不转义就会发生数据库查询错误
		search = search.replaceAll("'", "''");
		search = search.replaceAll("%", "/%");
		search = search.replaceAll("_", "/_");
		return search;
	}

    
    /**
	 * <pre>
	 * 把集合转为分隔符分隔的字符串.
	 * </pre>
	 *
	 * @param pobjInputList 集合list
	 * @param pstrDelimiters 分隔符
	 * @param pbTrimTokens 是否trim
	 * @param pbIgnoreEmptyTokens the pb ignore empty tokens
	 * @return the string
	 * 
	 * @author 孔泽峰
	 */
	@SuppressWarnings("rawtypes")
	public static String cutListToStringWithToken(List pobjInputList, String pstrDelimiters,
			boolean pbTrimTokens, boolean pbIgnoreEmptyTokens) {
		StringBuffer result = new StringBuffer();
		result.append("");
		Iterator inputIt = pobjInputList.iterator();
		while (inputIt.hasNext()) {
			String token = inputIt.next().toString();
			if (pbTrimTokens) {
				token = token.trim();
			}
			if ((!pbIgnoreEmptyTokens) || (token.length() != 0)) {
				result.append(token);
				result.append(pstrDelimiters);
			}
		}
		result.replace(result.length() - 1, result.length(), "");
		return result.toString();
	}


}
