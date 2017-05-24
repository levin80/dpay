<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<script type="text/javascript">
 function tipDiv(info){
	 var div = $("<div class='alert alert-warning alert-dismissible' id ='tip'></div>");
	 var button = $("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>");
	 var h4 = $("<h4><i class='icon fa fa-warning'></i>提示!</h4>");
	 
	 div.append(button).append(h4).append(info);
	 $("#tips").append(div);
 }
 </script>
<div class="box box-info">
  <div class="box-header with-border">
    <h3 class="box-title">编辑权限</h3>
  </div>
  <!-- form start -->
  <form class="form-horizontal" id="form1" name="form1"  action="${base}/permission/perm/updatePerm.do" method="post">
    <div class="box-body">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>所属功能</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-list"></i></span> 
            <ui:select name="permUpid" list="listperm" rootId="0" currentValue="${perm.permUpid }" defaultvalue="0" defaulttext="流量充值平台"/>
          </div>
        </div>
      </div>
      <div class="form-group">
        <label  class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>功能名称</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-cubes"></i></span>
            <input type="text" class="form-control" name="permName"  value="${perm.permName }" placeholder="function name">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label  class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>功能URL</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-link"></i></span>
            <input type="text" class="form-control" name="permUrl" value="${perm.permUrl }" placeholder="function url">
          </div>
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>状态</label>
        <div class="col-sm-6" style="margin-top: 5px;">
          <label>
          <input type="radio" name="permUse" value="1" checked="checked" class="minimal" <c:if test='${perm.permUse==1}'>checked</c:if>/>启用 </label>
          <label>
          <input type="radio" name="permUse" value="0"  class="minimal" <c:if test='${perm.permUse==0}'>checked</c:if>/>停用 </label>
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-2 control-label">功能描述</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-file-text"></i></span>
            <textarea class="form-control" rows="4" id="permNote" name="permNote" placeholder="Enter ...">${perm.permNote}</textarea>
          </div>
        </div>
      </div>


    <c:forTokens items="${perm.dependentUrl }" delims="|" var="url">
    <div class="form-group">
        <label class="col-sm-2 control-label">相关URL</label>
        <div class="col-sm-6">
            <div class="input-group"> 
                <span class="input-group-addon"><i class="fa fa-link"></i></span>
                <input type="text" class="form-control" name="recieveURL" value="${url}">
                <span class="input-group-addon"><a name="d" href="javascript:void(0);" target="_top" onclick="delURL(this)">删除</a></span>
           </div>
        </div>
    </div>
    </c:forTokens>
     <div class="form-group">
       <label for="inputPassword3" class="col-sm-2 control-label"><input type="button" id="addURL" name="addURL" size="50" value="新增相关URL"  /></label>
    </div>
   </div>
    <!-- /.box-body -->	
    <div class="box-footer">
      <input type="hidden"  name="id" value="<c:out value='${perm.id}'/>" />
      <input type="hidden" name="permId" value="<c:out value='${perm.permId}'/>"/>
      <input type="submit" name="" class="btn btn-primary pull-right" value="确认"/>
      <button type="button" class="btn btn-default pull-right" style="margin-right: 10px;" onclick="javascript:window.location.href='${base}/permission/perm/listPerm.do'">取消</button>
    </div>
    <!-- /.box-footer -->
  </form>
  <input type="hidden" id="userListUrl" name="userListUrl" value="${base}/permission/user/listUser.do" />
  <div  id ="tips">
  </div>
  
</div>
<script src="<c:url value='/clouds/console/res/plugins/datatables/media/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/datatables/media/js/dataTables.bootstrap.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/datatables/extensions/Select/js/dataTables.select.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/datatables/extensions/Buttons/js/dataTables.buttons.min.js'/>"></script>
<!-- iCheck 1.0.1 -->
<script src="<c:url value='/clouds/console/res/plugins/iCheck/icheck.min.js'/>"></script>
<!-- FastClick -->
<script src="<c:url value='/clouds/console/res/plugins/fastclick/fastclick.js'/>"></script>
<script src="<c:url value='/clouds/console/res/js/jquery.md5.js'/>"></script>
<script>
$(document).ready(function(){
	$("#addURL").click(function(){
		var num=$("input[name='recieveURL']").size();
		if(num>4){
			tipDiv("最多添加5个相关的URL");
			return;
		}
		var content="";
		 	content+="<div class='form-group'>";
			content+="<label class='col-sm-2 control-label'>相关URL</label>";
			content+="<div class='col-sm-6'>";
			content+="<div class='input-group'> <span class='input-group-addon'><i class='fa fa-link'></i></span><input type='text' class='form-control'  name='recieveURL' ><span class='input-group-addon'><a name='d' href='javascript:void(0);' target='_top' onclick='delURL(this)'>删除</a></span></div>";
			content+="</div>";
		    content+="</div>"; 
    		$(this).parent().parent().before(content);
    });
	
	
});
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    checkboxClass: 'icheckbox_minimal-blue',
    radioClass: 'iradio_minimal-blue'
  });
</script>
