<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<script type="text/javascript">

$(document).ready(function(){
	$("#form111").submit(function(){
		var isSubmit = true;
		$(this).find("[reg],[url]").each(function(){
			if(typeof($(this).prop("reg")) != "undefined"){
				if(!clientValidate($(this))){
					isSubmit=false;
				}
			}
		});
		var obj=$("#description");
		if(value.length>100){
			obj.siblings("span").addClass("err").html("角色描述最大100个字符");
			isSubmit=false;
		}
		return isSubmit;
});

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
    <h3 class="box-title">添加角色</h3>
  </div>
  <!-- form start -->
  <form class="form-horizontal" id="form111" name="form111"  action="${base}/permission/role/updateRole.do" method="post">
    <div class="box-body">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>角色名称</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" name="name" class="form-control" placeholder="rolename" value="${role.name}">
          </div>
        </div>
      </div>

      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">角色描述</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-file-text"></i></span>
            <textarea class="form-control" rows="4" id="description" name="description" placeholder="Enter ...">${role.description}</textarea>
          </div>
        </div>
      </div>
      
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>状态</label>
        <div class="col-sm-6" style="margin-top: 7px;">
          <label>
          <input type="radio" name="status" value="1" checked="checked" class="minimal" <c:if test='${role.status==1}'>checked</c:if>>启用 </label>
          <label>
          <input type="radio" name="status" value="0"  class="minimal" <c:if test='${role.status==0}'>checked</c:if>>停用 </label>
        </div>
      </div>
      <input type="hidden" name="id" value="<c:out value='${role.roleId}'/>"/>

    </div>
    <!-- /.box-body -->
    <div class="box-footer">
      <button type="submit" class="btn btn-primary pull-right">确认</button>
      <button type="button" class="btn btn-default pull-right" style="margin-right: 10px;" onclick="javascript:window.location.href='${base}/permission/role/listpage.do'">取消</button>
    </div>
    <!-- /.box-footer -->
  </form>
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
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    checkboxClass: 'icheckbox_minimal-blue',
    radioClass: 'iradio_minimal-blue'
  });
</script>
