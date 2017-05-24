<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datatables/dataTables.bootstrap.css'/>" >
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >


<div class="box">
  <div class="box-header">
    <h3 class="box-title">Data Table With Full Features</h3>
  </div>
  <!-- /.box-header -->
  <div class="box-body">
    <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
      <div class="row">
        <div class="col-sm-6">
          <div class="btn-group">
                      <button type="button" class="btn btn-default">新增</button>
                      <button type="button" class="btn btn-default">编辑</button>
                      <button type="button" class="btn btn-default">删除</button>
                    </div>
        </div>
        <div class="col-sm-6">
          <div id="example1_filter" class="dataTables_filter">
            <label>Search:
            <input type="search" class="form-control input-sm" placeholder="" aria-controls="example1">
            </label>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
            <thead>
              <tr role="row">
                <th tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending" style="padding-right: 8px;"><i class="fa fa-square-o" title="全选/取消"></i></th>
                <th class="sorting_asc" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 222px;">用户名</th>
                <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 100px;">状态</th>
                <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending" style="width: 265px;">注册日期</th>
                <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending" style="width: 189px;">最近登录日期</th>
                <th class="sorting" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending" style="width: 139px;">邮箱</th>
                <th  tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending" style="width: 139px;">操作</th>
                
              </tr>
            </thead>
            <tbody>
            <c:forEach items='${pagination.list}' var="user">
              <tr role="row" class="odd">
                <td ><input type="checkbox" name="ids" value="${user.userId}"/></td>
                <td class="sorting_1"><c:out value='${user.username }'/></td>
                <td>
                  <c:if test="${user.status== '1' }"><span class="label label-success">启用</span></c:if>
                  <c:if test="${user.status== '0' }"><span class="label label-danger">停用</span></c:if>
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
                     <a href="${start}">启用</a>
                   </c:if>
                   <a href="#" onclick="singleDel('${deleteUserById}')">删除</a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
            <tfoot>
              <tr>
                <th rowspan="1" colspan="1"></th>
                <th rowspan="1" colspan="1">用户名</th>
                <th rowspan="1" colspan="1">用户角色</th>
                <th rowspan="1" colspan="1">状态</th>
                <th rowspan="1" colspan="1">注册日期</th>
                <th rowspan="1" colspan="1">最近登录日期</th>
                <th rowspan="1" colspan="1">操作</th>
              </tr>
            </tfoot>
          </table>
        </div>
      </div>

    </div>
  </div>
  <!-- /.box-body -->
</div>
<script src="<c:url value='/clouds/console/res/plugins/datatables/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/datatables/dataTables.bootstrap.min.js'/>"></script>

<!-- iCheck 1.0.1 -->
<script src="<c:url value='/clouds/console/res/plugins/iCheck/icheck.min.js'/>"></script>
<!-- FastClick -->
<script src="<c:url value='/clouds/console/res/plugins/fastclick/fastclick.js'/>"></script>
<script>
var table;  
  $(function () {

	  $('input[type="checkbox"]').iCheck({
	      checkboxClass: 'icheckbox_minimal-blue',
	      radioClass: 'iradio_flat-blue'
	    });
      
	  table = $('#example1').DataTable({
		  "pagingType": "simple_numbers",//设置分页控件的模式  
	      "paging": true,
	      "lengthChange": false,
	      "searching": false,//屏蔽datatales的查询框
	      aLengthMenu:[10],//设置一页展示10条记录  
	      "ordering": true,
	      "info": true,
	      "autoWidth": false,
	      "oLanguage": {  //对表格国际化  
	            "sLengthMenu": "每页显示 _MENU_条",    
	            "sZeroRecords": "没有找到符合条件的数据",    
	        //  "sProcessing": "&lt;img src=’./loading.gif’ /&gt;",    
	            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",    
	            "sInfoEmpty": "木有记录",    
	            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",    
	            "sSearch": "搜索：",    
	            "oPaginate": {    
	            "sFirst": "首页  ",    
	            "sPrevious": "前一页  ",    
	            "sNext": "  后一页",    
	            "sLast": "  尾页"         
	             }
	      },
	      "processing": true, //打开数据加载时的等待效果  
	          "serverSide": true,//打开后台分页  
	          "ajax": {  
	              "url": "../../alarms/datatablesTest",   
	              "dataSrc": "aaData",   
	              "data": function ( d ) {  
	                  var level1 = $('#level1').val();  
	                  //添加额外的参数传给服务器  
	                  d.extra_search = level1;  
	              }  
	          },  
	          "columns": [  
	              { "data": "total" },  
	              { "data": "level" }  
	          ]  
	     });
  });
  
  function search1()  
  {  
      table.ajax.reload();  
  }  
</script>
</script>

