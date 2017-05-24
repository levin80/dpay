package com.mi.dpay.web.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.mi.dpay.beans.HbPermission;

/**
 * Description: 属性select标签
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-3-5 上午11:26:02 
 */

public class TreeSelectTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String list; 
	private String  rootId= "0"; 
	private String currentValue = "0";
	private String defaulttext = "";
	private String defaultvalue = "0";
	
	private List<HbPermission> listPerm=new ArrayList<HbPermission>();
	private int intLevel;
	private StringBuilder builder;
	private boolean selected;
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		try {
			listPerm=(List<HbPermission>)pageContext.getRequest().getAttribute(list);
			builder=new StringBuilder("");
			selected=false;
			builder.append("<select id='"+name+"' name='"+name+"'>");
            if(currentValue.equals("0")){
                builder.append("<option value='"+currentValue+"' selected=\"selected\" >所有分类</option>");
            }else {
                builder.append("<option value='"+currentValue+"' >"+defaulttext+"</option>");
                builder.append("<option value=''>所有分类</option>");
            }
            appendRoot();
			builder.append("</select>");
			pageContext.getOut().print(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;
	}
	
	public void appendRoot(){
		if(listPerm==null || listPerm.size()==0){
			return;
		}
		int len =listPerm.size(); 
		for(int i= 0;i<len;i++){ 
			if(rootId.equals(listPerm.get(i).getPermUpid())){ 
				if(!"0".equals(currentValue) && currentValue.equals(listPerm.get(i).getPermId())){
					selected=true;
					builder.append("<option value="+listPerm.get(i).getPermId()+" selected=\"selected\">"+"..├-"+listPerm.get(i).getPermName()+"</option>");
				}else{
					builder.append("<option value="+listPerm.get(i).getPermId()+">"+"..├-"+listPerm.get(i).getPermName()+"</option>");
				}
				for(int j=0;j<len;j++){
					appendSubOption(listPerm.get(i),listPerm.get(j));
				} 
			} 
		} 
	}
	
	public void appendSubOption(HbPermission current,HbPermission next){
		String blank = ".."; 
		int len=listPerm.size();
		if(current.getPermId().equals(next.getPermUpid())){
			intLevel =0;
			int intlvl =getLevel(rootId,current); 
			for(int a=0;a<=intlvl;a++){
				blank += "..";
			}
			blank += "├-"; 
			if(!"0".equals(currentValue)  && next.getPermId()==currentValue){
				builder.append("<option value="+next.getPermId()+" selected=\"selected\">"+blank+next.getPermName()+"</option>");
			}else{
				builder.append("<option value="+next.getPermId()+">"+blank+next.getPermName()+"</option>");
			}
			for(int j=0;j<len;j++){
				appendSubOption(next,listPerm.get(j)); 
			} 
		}
		
	}
	
	public int getLevel(String topId, HbPermission currentitem){ 
		String pid =currentitem.getPermUpid(); 
		if(!topId.equals(pid)){
			for(HbPermission temp:listPerm){
				if(pid.equals(temp.getPermId())){
					intLevel++;
					this.getLevel(topId,temp); 
				} 
			}
			
		}
		return intLevel; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}


	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getDefaulttext() {
		return defaulttext;
	}

	public void setDefaulttext(String defaulttext) {
		this.defaulttext = defaulttext;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public List<HbPermission> getListPerm() {
		return listPerm;
	}

	public void setListPerm(List<HbPermission> listPerm) {
		this.listPerm = listPerm;
	}

	public int getIntLevel() {
		return intLevel;
	}

	public void setIntLevel(int intLevel) {
		this.intLevel = intLevel;
	}

	public StringBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(StringBuilder builder) {
		this.builder = builder;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}



}
