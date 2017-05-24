<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<script type="text/javascript">

 $(function(){
	 $("#btn").click(function(){
         var tmpPassword=$("#password").val();
         if(tmpPassword!=''){
             var ps="^[a-zA-Z0-9\u4e00-\u9fa5]{6,8}$";
             var vv=tmpPassword.match(ps);
             if(vv==null){
                 alert("密码必须是中英文或数字字符，长度6-8");
                 $("#password").val("");
                 $("#password").focus();
                 return ;
             }
             if(tmpPassword.length>0){
                 var md5Password=$.md5(tmpPassword);
                 $("#password").val(md5Password);
             }
         }
         var email = document.getElementById('email').value;

         if ((email != '' && email.length > 50)) {
             $('#spanEmail').html("email不能大于50个字符，并且需要输入正确的格式！");
             return false;
         } else
             $('#spanEmail').html('');
         var isChecked = false;
         $("input[name='ids']").each(function(){
             var a = $(this);
             if(a.prop("checked")){
                 isChecked = true;
             }
         });
         if(!isChecked){
            // alert("请选择角色!");
            tipDiv("请选择角色!");
            // $("#tips").show().append("请选择角色!");
             return false;
         }
         
			var table = document.getElementById("form22");
			table.submit();
		});
 });
 
 function checkEmail(tempEmail){
		if(!(/(^[a-zA-Z]|^[a-zA-Z][\w-_\.]*[a-zA-Z0-9])@(\w+\.)+\w+$/.test(tempEmail))){
			return false;
		} else {
			return true;
		}
	}
	function checkNoZh(word){
		if ((/^[^\u4e00-\u9fa5]*$/.test(word))) {
		return true;
	} else {
		return false;
	}
	}

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
    <h3 class="box-title">编辑用户</h3>
  </div>
  <!-- form start -->
  <form class="form-horizontal" id="form22" name="form1"  action="${base}/permission/user/addUser.do" method="post">
    <div class="box-body">
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>登录名称</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon">@</span>
            <input type="text" name="username" class="form-control" placeholder="Username" value="${user.username }">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>登录密码</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-eye-slash"></i></span>
            <input type="password" class="form-control" id="password" name="password"  placeholder="Password" value="${user.password }">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>注册邮箱</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${user.email}">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>单位名称</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon">@</span>
            <input type="text" class="form-control" name="fullName" placeholder="name" value="${user.fullName}">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>费率</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon" style="padding-right: 16px;padding-left: 16px;"><i class="fa fa-dollar"></i></span>
            <input type="text" class="form-control" name="per" placeholder="万分之一为单位，填1表示0.01%" value="${user.per}">
          </div>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>性别</label>
        <div class="col-sm-6" style="margin-top: 5px;">
          <label>
          <input type="radio" name="gender" class="minimal" value="1" <c:if test='${user.gender==1}'>checked</c:if>>男 </label>
          <label>
          <input type="radio" name="gender" class="minimal" value="0" <c:if test='${user.gender==0}'>checked</c:if>>女 </label>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>状态</label>
        <div class="col-sm-6" style="margin-top: 5px;">
          <label>
          <input type="radio" name="status" value="1" checked="checked" class="minimal" <c:if test='${user.status==1}'>checked</c:if>>启用 </label>
          <label>
          <input type="radio" name="status" value="0"  class="minimal" <c:if test='${user.status==0}'>checked</c:if>>停用 </label>
        </div>
      </div>
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>角色</label>
        <div class="col-sm-6" style="margin-top: 5px;">
        <c:forEach items='${listrole}' var="role" varStatus="index">
        <c:set var="isDoing" value="0"/>
            <c:forEach items='${user.roles}' var="role1">
                <c:if test="${role1.id==role.id }">
                    <c:set var="isDoing" value="1"/>
                    <label><input type="checkbox" class="minimal" name="ids" value="${role.roleId }" checked>${role.name } </label>
                </c:if>
            </c:forEach>
            <c:if test="${isDoing==0 }">
				    <label><input type="checkbox" class="minimal" name="ids" value="${role.roleId }">${role.name } </label>
			</c:if>
		    
	    </c:forEach>
<!--           <label><input type="checkbox" class="minimal" checked>系统管理员 </label> -->
<!--           <label><input type="checkbox" class="minimal">配置管理员 </label> -->
<!--           <label><input type="checkbox" class="minimal">超级管理员 </label> -->
        </div>
      </div>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
      <button type="button" id="btn" class="btn btn-primary pull-right">Sign in</button>
      <button type="button" class="btn btn-default pull-right" style="margin-right: 10px;" onclick="javascript:window.location.href='${base}/permission/user/listpage.do'">Cancel</button>
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
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    checkboxClass: 'icheckbox_minimal-blue',
    radioClass: 'iradio_minimal-blue'
  });
</script>
