<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<script type="text/javascript">

 $(function(){
	 $("#btn").click(function(){
			var table = document.getElementById("form22");
			table.submit();
		});
 });
 </script>
<div class="box box-info">
  <div class="box-header with-border">
    <h3 class="box-title">流量充值</h3>
  </div>
  <!-- form start -->
  <form class="form-horizontal" id="form22" name="form22"  action="${base}/order/productList.do" method="post">
    <div class="box-body">

      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label"><i class="fa fa-star text-yellow" style="margin-right: 5px;"></i>手机号码</label>
        <div class="col-sm-6">
          <div class="input-group"> <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
            <input type="phone" class="form-control" id="phone" name="phone" placeholder="请输入待充值手机号码">
          </div>
        </div>
      </div>

    </div>
    <!-- /.box-body -->
    <div class="box-footer">
      <button type="button" id="btn" class="btn btn-primary pull-right">确认</button>
      <button type="button" class="btn btn-default pull-right" style="margin-right: 10px;" onclick="javascript:window.location.href='${base}/charge/accountCharge.do'">取消</button>
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
