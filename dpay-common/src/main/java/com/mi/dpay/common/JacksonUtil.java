package com.mi.dpay.common;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author levin
 *
 */
public class JacksonUtil {

	/**
	 * 实体bean转换为json串
	 * 
	 * @param bean
	 * @return
	 */
	public static String beanToJSON(Object bean) {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
			objectMapper.writeValue(writer, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * map转换为json串
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToJSON(Map<?, ?> map) {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.writeValue(writer, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * list转换为json串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJSON(List<?> list) {
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		try {
			objectMapper.writeValue(writer, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	/**
	 * json串转换实体bean
	 * 
	 * @param value
	 * @param classType
	 * @return
	 */
	public static Object jSONtoBean(String value, Class<?> classType) {
		ObjectMapper objectMapper = new ObjectMapper();
		Object bean = null;
		try {
			bean = objectMapper.readValue(value, classType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * json串转换list结构
	 * 
	 * @param value
	 * @return
	 */
	public static List<?> jSONtoList(String value) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> list = null;
		try {
			list = objectMapper.readValue(value, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * json串转换map结构
	 * 
	 * @param value
	 * @return
	 */
	public static Map<Object, Object> jSONtoMap(String value) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<Object, Object> map = null;
		try {
			map = objectMapper.readValue(value, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * json串转换数组结构
	 * 
	 * @param value
	 * @param classType
	 * @return
	 */
	public static Object[] jSONtoArray(String value, Class<Object[]> classType) {
		ObjectMapper objectMapper = new ObjectMapper();
		Object array[] = null;
		try {
			array = objectMapper.readValue(value, classType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}
}
