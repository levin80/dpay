package com.mi.dpay.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Description:将pom文件中定义的常量通过此类供java中使用
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-7-4 下午12:40:04 
 */

public class Config implements Map{
	
	private Map map;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object arg0) {
		return map.containsKey(arg0);
	}

	public boolean containsValue(Object arg0) {
		return map.containsValue(arg0);
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public Object get(Object arg0) {
		return map.get(arg0);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set keySet() {
		return map.keySet();
	}

	public Object put(Object arg0, Object arg1) {
		return map.put(arg0, arg1);
	}

	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	public Object remove(Object arg0) {
		return map.remove(arg0);
	}

	public int size() {
		return map.size();
	}

	public Collection values() {
		return map.values();
	}
}
