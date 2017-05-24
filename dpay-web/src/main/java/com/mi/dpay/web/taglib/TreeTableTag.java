package com.mi.dpay.web.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.mi.dpay.beans.HbPermission;


/**
 * Description: table树形菜单
 * @author 李晓伟 (xwlig@isoftstone.com) <p>iSoftStone</p>
 * @version 1.0 2015-3-5 上午11:28:49 
 */

public class TreeTableTag extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String list; 
	private String rootId;
	private String editURL="";
	private String delURL="";
	private String stopURL="";
	private String startURL="";
	
	private List<HbPermission> listPerm=new ArrayList<HbPermission>();
	private StringBuilder builder;
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		try {
			listPerm=(List<HbPermission>)pageContext.getRequest().getAttribute(list);
			builder=new StringBuilder("");
			builder.append("<table id='"+name+"' name='"+name+"' cellspacing='0' summary='' class='tab'>");
			builder.append(
				"<thead>" +
					"<tr>" +
						"<th><input type='checkbox' id='all' name='all' title='全选/取消' /></th>" +
						"<th>功能名称</th>" +
						"<th>层级关系</th>" +
						"<th>功能URL</th>" +
						"<th>功能描述</th>" +
						"<th>状态</th>" +
						"<th>操作</th>" +
					"</tr>" +
				"</thead>");
			builder.append("<tbody>");
			appendRoot();
			builder.append(
					"<tr>" +
						"<td colspan='7'>" +
							"选择： " +
							"<a id='checkall' href='#' >全选</a> <samp>-</samp>" +
							"<a id='cancelall' href='#' >取消</a>" +
						"</td>" +
					"</tr>");
			builder.append("</tbody>");
			builder.append("</table>");
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
			HbPermission perm=listPerm.get(i);
			if(rootId.equals(perm.getPermUpid())){ 
				String status=perm.getPermUse()==1?"启用":"停用";
				String editurl=editURL+"?id="+perm.getPermId();
				String delurl=delURL+"?id="+perm.getPermId();
				String stopurl=stopURL+"?id="+perm.getPermId()+"&status=0";
				String starturl=startURL+"?id="+perm.getPermId()+"&status=1";
				String temp=perm.getPermUse()==1?"<a href='"+stopurl+"'>停用</a>":"<a href='"+starturl+"'>启用</a>";
				builder.append(
						"<tr id='node-"+perm.getPermId()+"'>" +
							"<td><input type='checkbox' name='ids' value='"+perm.getPermId()+"'/></td>" +
							"<td>"+perm.getPermName()+"</td>" +
							"<td>"+perm.getLevelStr()+"</td>" +
							"<td>"+perm.getPermUrl()+"</td>" +
							"<td>"+perm.getPermNote()+"</td>" +
							"<td>"+status+"</td>" +
							"<td>" +
								"<a href='"+editurl+"'>编辑</a>&nbsp;&nbsp;" +
								"<a href='#' onclick=singleDel("+"'"+delurl+"'"+")>删除</a>&nbsp;&nbsp;" +
								temp+
							"</td>" +
						"</tr>");
				for(int j=0;j<len;j++){
					appendSubOption(perm,listPerm.get(j));
				} 
			} 
		} 
	}
	
	public void appendSubOption(HbPermission current,HbPermission next){
		int len=listPerm.size();
		if(current.getPermId()==next.getPermUpid()){
			String status=next.getPermUse()==1?"启用":"停用";
			String editurl=editURL+"?id="+next.getPermId();
			String delurl=delURL+"?id="+next.getPermId();
			String stopurl=stopURL+"?id="+next.getPermId()+"&status=0";
			String starturl=startURL+"?id="+next.getPermId()+"&status=1";
			String temp=next.getPermUse()==1?"<a href='"+stopurl+"'>停用</a>":"<a href='"+starturl+"'>启用</a>";
			builder.append(
					"<tr id='node-"+next.getPermId()+"' class='child-of-node-"+next.getPermUpid()+"'>" +
						"<td><input type='checkbox' name='ids' value='"+next.getPermId()+"'/></td>" +
						"<td>"+next.getPermName()+"</td>" +
						"<td>"+next.getLevelStr()+"</td>" +
						"<td>"+next.getPermUrl()+"</td>" +
						"<td>"+next.getPermNote()+"</td>" +
						"<td>"+status+"</td>" +
						"<td>" +
							"<a href='"+editurl+"'>编辑</a>&nbsp;&nbsp;" +
							"<a href='#' onclick=singleDel("+"'"+delurl+"'"+")>删除</a>&nbsp;&nbsp;" +
							temp+
						"</td>" +
					"</tr>");
			for(int j=0;j<len;j++){
				appendSubOption(next,listPerm.get(j)); 
			} 
		}
		
	}

	public void setName(String name) {
		this.name = name;
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

	public void setEditURL(String editURL) {
		this.editURL = editURL;
	}

	public void setDelURL(String delURL) {
		this.delURL = delURL;
	}

	public void setStopURL(String stopURL) {
		this.stopURL = stopURL;
	}

	public void setStartURL(String startURL) {
		this.startURL = startURL;
	}
	
	
	
	
	
	
	
	
	

}
