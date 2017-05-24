<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"	href="<c:url value='/clouds/console/res/plugins/datatables/media/css/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet"	href="<c:url value='/clouds/console/res/plugins/datatables/extensions/Select/css/select.dataTables.min.css'/>">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet"	href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>">
<link rel="stylesheet"	href="<c:url value='/clouds/console/res/plugins/tabletree/css/jquery.treeTable.css'/>">
<div class="box">
  <div class="box-header">
    <h3 class="box-title">权限列表</h3>
  </div>
  <!-- /.box-header -->
  <div class="box-body">
    <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
      <div class="row">
        <div class="col-sm-6">
          <div class="btn-group">
            <button type="button" class="btn btn-default" onClick="javascript:window.location.href='${base}/permission/perm/forwardperm.do'"><i class="fa fa-plus" style="margin-right: 3px;"></i>新增</button>
            <button type="button" class="btn btn-default" onClick="editperm();"><i class="fa fa-edit" style="margin-right: 3px;"></i>编辑</button>
            <button type="button" class="btn btn-default" onClick="changestatus();"><i class="fa fa-edit" style="margin-right: 3px;"></i>停/启用</button>
            <button type="button" class="btn btn-default" onClick="deleteperm();"><i class="fa fa-trash" style="margin-right: 3px;"></i>删除</button>
          </div>
        </div>
      </div>
      <form id="form1" name="form1" action="${base}/permission/perm/listAllPerm.do" method="post">
        <ui:perm var="list" list="${listperm }"/>
        <div class="row">
        <div class="col-sm-12">
        <table id="treeid" name="treeid"  class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
            <thead>
            <tr>
              <th width="2%"><input type='checkbox' id='all' name='all' title='全选/取消' /></th>
              <th>功能名称</th>
              <th>功能描述</th>
              <th>状态</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list }" var="perm">
            
            <tr id="node-${perm.permId }" <c:if test="${perm.permUpid ne '0' }">class=child-of-node-${perm.permUpid }</c:if>>
               <td><input type='checkbox' name='ids' value='${perm.permId }' lang="${perm.permUse}"/></td>
               <td>${perm.permName }</td>
               <td class="wp"><c:out value="${perm.permNote }" escapeXml="true"/></td>
               <td ><c:if test="${perm.permUse==1 }">启用</c:if><c:if test="${perm.permUse==0 }">停用</c:if></td>

          </tr>
          </c:forEach>
          
<!--           <tr> -->
<!--             <td colspan="5">选择： <a id="checkall" href="#">全选</a> <samp>-</samp> <a id="cancelall" href="#">取消</a> </td> -->
<!--           </tr> -->
          </tbody>
          
        </table>
        </div>
        </div>
      </form>
    </div>
  </div>
  <!-- /.box-body -->
  <div  id ="tips"></div>
</div>
<script	src="<c:url value='/clouds/console/res/plugins/datatables/media/js/jquery.dataTables.min.js'/>"></script>
<script	src="<c:url value='/clouds/console/res/plugins/datatables/media/js/dataTables.bootstrap.min.js'/>"></script>
<script	src="<c:url value='/clouds/console/res/plugins/datatables/extensions/Select/js/dataTables.select.min.js'/>"></script>
<script	src="<c:url value='/clouds/console/res/plugins/datatables/extensions/Buttons/js/dataTables.buttons.min.js'/>"></script>
<!-- iCheck 1.0.1 -->
<script	src="<c:url value='/clouds/console/res/plugins/iCheck/icheck.min.js'/>"></script>
<!-- FastClick -->
<script	src="<c:url value='/clouds/console/res/plugins/fastclick/fastclick.js'/>"></script>
<script	src="<c:url value='/clouds/console/res/plugins/tabletree/js/jquery.treeTable.min.js'/>"></script>
<script>
$(document).ready(function() {
	$("#treeid").treeTable({treeColumn:1});
});
$(document).ready(function(){
	$("input[name='ids']").prop("checked", false);
	$("#all").click(function(){
     	if($("#all").prop("checked")){
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

function editperm(){
	if(!isChecked()){
		tipDiv("请至少选择一条记录");
		return;
	}
	
	$("input[name='ids']").each(function(i){
		    var id;
		    var isCheck = $(this).prop("checked");
		   
		    if('checked' == isCheck || isCheck){
		        id = $(this).attr("value");
		        window.location.href="${base}/permission/perm/getPerm.do?id="+id;	
		    }
	});
	  
}

function isChecked(){
	var isselected=false;
	$("input[name='ids']").each(function(){
		if($(this).prop("checked")){
			isselected=true;
		}
	});
	return isselected;
}


function deleteperm(){
	if(!isChecked()){
		tipDiv("请至少选择一条记录");
		return;
	}
	$("input[name='ids']").each(function(i){
	    var id;
	    var isCheck = $(this).prop("checked");
	   
	    if('checked' == isCheck || isCheck){
	        id = $(this).attr("value");
	        window.location.href="${base}/permission/perm/deletePermById.do?id="+id;	
	    }
    });

}


function changestatus(){
	if(!isChecked()){
		tipDiv("请至少选择一条记录");
		return;
	}
	$("input[name='ids']").each(function(i){
	    var bs,status;
	    var isCheck = $(this).prop("checked");
	   
	    if('checked' == isCheck || isCheck){
	    	 id = $(this).attr("value");
	    	bs = $(this).attr("lang");
	        if(bs == 1){
	        	status = 0;
	        }else{
	        	status = 1;
	        }
	        window.location.href="${base}/permission/perm/updatePermStatus.do?id="+id+"&"+ "status="+status;	
	    }
    });
	
}
	//提示信息
	function tipDiv(info) {
		var div = $("<div class='alert alert-warning alert-dismissible' id ='tip'></div>");
		var button = $("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>");
		var h4 = $("<h4><i class='icon fa fa-warning'></i>提示!</h4>");

		div.append(button).append(h4).append(info);
		$("#tips").append(div);
	}
</script>
</script>
