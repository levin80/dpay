package com.mi.dpay.web.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.mi.dpay.beans.HbPermission;

/**
 * Description: table树形菜单
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-3-5 上午11:29:10 
 */

public class PermTableTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	private String var;
	private String rootId = "0";
	private List<HbPermission> list=new ArrayList<HbPermission>();
	private List<HbPermission> listNew=new ArrayList<HbPermission>();
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		listNew.clear();
		appendRoot();
		pageContext.setAttribute(var, listNew);
		return TagSupport.SKIP_BODY;
	}
	
	public void appendRoot(){
		if(list==null || list.size()==0){
			return;
		}
		int len =list.size(); 
		for(int i= 0;i<len;i++){ 
			HbPermission perm=list.get(i);
			if(rootId.equals(perm.getPermUpid())){ 
				listNew.add(perm);
				for(int j=0;j<len;j++){
					appendSubOption(perm,list.get(j));
				}
			} 
		} 
	}
	
	public void appendSubOption(HbPermission current,HbPermission next){
		int len=list.size();
		if(current.getPermId().equals(next.getPermUpid())){
			listNew.add(next);
			for(int j=0;j<len;j++){
				appendSubOption(next,list.get(j)); 
			}
		}
		
	}
	

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public void setList(List<HbPermission> list) {
		this.list = list;
	}
	public void setVar(String var) {
		this.var = var;
	}

	

	
	

}
