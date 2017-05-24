<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>用户管理_用户管理</title>
<script type="text/javascript">
	function isChecked(){
		var isselected=false;
		$("input[name='ids']").each(function(){
			if($(this).prop("checked")){
				isselected=true;
			}
		});
		return isselected;
	}
	function batchStart(){
		if(!isChecked()){
			alert("请选择记录");
			return;
		}
		var form = document.getElementById("form1");
		form.action="${base}/permission/user/batchUpdateUserStatus.do?status=1";
		form.submit();
	}
	function batchStop(){
		if(!isChecked()){
			alert("请选择记录");
			return;
		}
		var form = document.getElementById("form1"); 
		form.action="${base}/permission/user/batchUpdateUserStatus.do?status=0";
		form.submit();
	}
	function singleDel(url){
		if(confirm("确定删除记录")){
			document.location=url;			
		}
	}
	function batchDel(){
		if(!isChecked()){
			alert("请选择记录");
			return;
		}
		if(confirm("确定删除这些记录")){
			var form = document.getElementById("form1"); 
			form.action="${base}/permission/user/batchDelUserById.do";
			form.submit();
		}
		
	}

    $(function(){searchText('#searchText','#search',40);});
    //搜寻预处理
    function goSearch(){
        submitText('#searchText','#search',40);
        var form = document.getElementById("form1");
        form.submit();
    }
    //回车响应搜索
	$(document).keydown(function(event){ 
		if(event.keyCode==13){
			var st = $('#searchText').val();
	        if(st == '' || st == '请输入用户名'){
	        	_inputgotoPage();
	        }
	        else 
			{goSearch();}
	     
		}
	});

    function orderBy(orderBy,orderByStatus){
        $("#orderBy").val(orderBy);//代表按那个字段排序
        $("#orderByStatus").val(orderByStatus);//代表排序方式，即升序还是降序
        goSearch('#form1','#userSearch');
    }

      $(document).ready(function(){

          searchText('#searchText','#userSearch',40);
          pageInitialize('#form1','#userSearch');
          $('#goSearch').click(function(){
              $("#pageNo").val(1);
              goSearch('#form1','#userSearch');
          });

		$("#all").click(function(){
	     	if($(this).prop("checked")){
	        	$("input[name='ids']").prop("checked", true);
	        }else{
	        	$("input[name='ids']").prop("checked", false);
	        }
	    });
		$("#checkall").click(function(){
			$("input[name='ids']").prop("checked", true);
			$("#all").prop("checked",true)
		});
		$("#cancelall").click(function(value){
			$("input[name='ids']").prop("checked", false);
			$("#all").prop("checked",false)
		});
	});
</script>
</head>
<body id="main">
<div class="frameL"><div class="box"><div class="menu icon">
    <jsp:include page="/clouds/console/common/permissionmenu.jsp"/>
</div></div></div>
<div class="frameR"><div class="content">

    <div class="loc icon"><samp class="t12"></samp><fmt:message key='menu.current.loc'/>：权限管理&nbsp;&raquo;&nbsp;<span class="gray" title="用户管理">用户管理</span></div>

<form id="form1" name="form1" action="${base}/permission/user/listUser.do" method="post">
	<div class="sch">
        <input type="hidden" id="userSearch" name="userSearch" />
        <p>
            用户名：<input type="text" id="searchName" name="searchName" value="${searchName}" title="请输入用户名" class="text20 medium gray" />
            邮箱：<input type="text" id="searchEmail" name="searchEmail" value="${searchEmail}" title="请输入用户名" class="text20 medium gray" />
            <select id="searchRole" name="searchRole" value="${searchRole}">
                <option value="">角色</option>
                <c:forEach items='${roleList}' var="role">
                    <option value="${role.roleId}"<c:if test='${searchRole==role.roleId}'> selected </c:if>>${role.name}</option>
                </c:forEach>
            </select>
            <select id="searchStatus" name="searchStatus" value="${searchStatus}">
                <option value="">状态</option>
                <option value="1" <c:if test='${searchStatus == 1}'> selected </c:if>>启用</option>
                <option value="0" <c:if test='${searchStatus == 0}'> selected </c:if>>停用</option>
            </select>
            <input type="button" onclick="goSearch();"  class="hand btn60x20" value='<fmt:message key="tag.search"/>' />
        </p>
    </div>
     <div class="page_c">
        <span class="l">
            <c:url value="/${system}/permission/user/forwarduser.do" var="addUser"/>
            <input type="button" onclick="batchStop();" value="<fmt:message key="tag.stop"/>" class="hand btn60x20" />
            <input type="button" onclick="batchStart();" value="<fmt:message key="tag.start"/>" class="hand btn60x20" />
            <input type="button" onclick="batchDel();" value="<fmt:message key="tag.delete"/>" class="hand btn60x20" />
        </span>
        <span class="r inb_a">
            <a href="${addUser}" title="<fmt:message key="tag.add"/>" class="btn80x20"><fmt:message key="tag.add"/></a>
        </span>
    </div>
    
	<table cellspacing="0" summary="" class="tab">
		<thead>
			<th width="2%"><input type="checkbox" id="all" name="all" title="全选/取消" /></th>
			<th>用户名</th>
			<th>用户角色</th>
			<th>状态</th>
			<th>注册日期</th>
			<th>最近登录日期</th>
			<th>邮箱</th>
            <th>操作</th>
		</thead>
		<tbody>
			<c:forEach items='${pagination.list}' var="user">
			<tr>
				<td><input type="checkbox" name="ids" value="${user.userId}"/></td>
                <td><c:out value='${user.username }'/></td>
                <td>
                <c:forEach items='${user.roles}' var="role">
                	<c:out value='${role.name }'/>&nbsp;
                	<%--<c:if test="${role.flag==1 }">后台</c:if>
                	<c:if test="${role.flag==2 }">前台</c:if>
                --%></c:forEach>
                </td>
                <td>
                  <c:if test="${user.status==1 }">启用</c:if>
                  <c:if test="${user.status==0 }">停用</c:if>
                </td>
                <td><fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><c:out value='${user.email }'/></td>
                <td>
                   <c:url value="/${system }/permission/user/getUser.do" var="getUser">
                     <c:param name="id" value="${user.userId }"></c:param>
                   </c:url>
                   <c:url value="/${system }/permission/user/deleteUserById.do" var="deleteUserById">
                     <c:param name="id" value="${user.userId }"></c:param>
                   </c:url>
                   <c:url value="/${system }/permission/user/updateUserStatus.do" var="start">
                     <c:param name="id" value="${user.userId }"></c:param>
                     <c:param name="status" value="1"></c:param>
                   </c:url>
                   <c:url value="/${system }/permission/user/updateUserStatus.do" var="stop">
                     <c:param name="id" value="${user.userId }"></c:param>
                     <c:param name="status" value="0"></c:param>
                   </c:url>
                   <a href="${getUser }">编辑</a>
                   <c:if test="${user.status==1 }">
                     <a href="${stop }">停用</a>
                   </c:if>
                   <c:if test="${user.status==0 }">
                     <a href="${start }">启用</a>
                   </c:if>
                   <a href="#" onclick="singleDel('${deleteUserById}')">删除</a>
                </td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
                	选择： <a id="checkall" href="#" >全选</a> <samp>-</samp>
                		  <a id="cancelall" href="#" >取消</a>
				</td>
			</tr>
		</tbody>
	</table>
	
	<div class="page_c">
	    <span class="l inb_a">
            <input type="button" onclick="batchStop();" value="<fmt:message key="tag.stop"/>" class="hand btn60x20" />
            <input type="button" onclick="batchStart();" value="<fmt:message key="tag.start"/>" class="hand btn60x20" />
            <input type="button" onclick="batchDel();" value="<fmt:message key="tag.delete"/>" class="hand btn60x20" />
        </span>
         <span class="r page">
            <input type="hidden" value="${orderBy}" id="orderBy" name="orderBy" />
            <input type="hidden" value="${orderByStatus}" id="orderByStatus" name="orderByStatus" />
            <input type="hidden" value="${pageNo}" id="pageNo" name="pageNo" />
            <input type="hidden" value="${pagination.totalCount}" id="paginationPiece" name="paginationPiece" />
            <input type="hidden" value="${pagination.pageNo}" id="paginationPageNo" name="paginationPageNo" />
            <input type="hidden" value="${pagination.totalPage}" id="paginationTotal" name="paginationTotal" />
            <input type="hidden" value="${pagination.prePage}" id="paginationPrePage" name="paginationPrePage" />
            <input type="hidden" value="${pagination.nextPage}" id="paginationNextPage" name="paginationNextPage" />
                      共<var id="pagePiece" class="orange">0</var>条
          <var id="pageTotal">1/1</var>
          <span id="previousNo" class="inb" title="上一页">上一页</span>
          <a href="javascript:void(0);" id="previous" class="hidden" title="上一页">上一页</a>
          <span id="nextNo" class="inb" title="下一页">下一页</span>
          <a href="javascript:void(0);" id="next" class="hidden" title="下一页">下一页</a>
          <input type="text" id="number" name="number" class="txts" size="3" />
          <input type="button" id="skip" class="hand" value='跳转' />
        </span>
    </div>
</form>
</div></div>
</body>


