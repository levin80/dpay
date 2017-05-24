<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datatables/media/css/dataTables.bootstrap.min.css'/>" >
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datatables/extensions/Select/css/select.dataTables.min.css'/>" >
  <!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >



<div class="box">
  <div class="box-header">
    <h3 class="box-title">资金记录</h3>
  </div>
  <!-- /.box-header -->
  <div class="box-body">
    <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
      <div class="row">
        <div class="col-sm-6">
          <div class="btn-group">
                      <button type="button" class="btn btn-default" onclick="javascript:window.location.href='${base}/chargeList.do'"><i class="fa fa-plus" style="margin-right: 3px;"></i>查看</button>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-12">
          <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
            <thead>
              <tr role="row">
                <th rowspan="1" colspan="1" width="3%"></th>
                <th rowspan="1" colspan="1"></th>
                <th rowspan="1" colspan="1">发生时间</th>
                <th rowspan="1" colspan="1">类型</th>
                <th rowspan="1" colspan="1">交易金额(元)</th>
                <th rowspan="1" colspan="1">余额</th>
                <th rowspan="1" colspan="1">状态</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
              
                <th rowspan="1" colspan="1"></th>
                <th rowspan="1" colspan="1"></th>
                <th rowspan="1" colspan="1">发生时间</th>
                <th rowspan="1" colspan="1">类型</th>
                <th rowspan="1" colspan="1">交易金额(元)</th>
                <th rowspan="1" colspan="1">余额</th>
                <th rowspan="1" colspan="1">状态</th>
<!--                 <th rowspan="1" colspan="1">操作</th> -->
              </tr>
            </tfoot>
          </table>
        </div>
      </div>

    </div>
  </div>
  <!-- /.box-body -->
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
<script>
var table;  
  $(function () {

	    $('input[type="checkbox"].minimal').iCheck({
	        checkboxClass: 'icheckbox_minimal-blue'
	      });
      
	  table = $('#example1').DataTable({
		  "pagingType": "simple_numbers",//设置分页控件的模式  
          "paging": true,
          "lengthChange": false,
          "searching": true,//屏蔽datatales的查询框
          "lengthMenu":[10],//设置一页展示10条记录  
          "ordering": true,
          "info": true,
          "autoWidth": true,
          "language": {  //对表格国际化  
                "lengthMenu": "每页显示 _MENU_条",    
                "sZeroRecords": "没有找到符合条件的数据",    
            //  "sProcessing": "&lt;img src=’./loading.gif’ /&gt;",    
                "info": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",    
                "infoEmpty": "没有记录",    
                "infoFiltered": "(从 _MAX_ 条数据中查询)",    
                "search": "搜索：", 
                "searchPlaceholder":"请输入查询值",
                "paginate": {    
                    "first": "首页  ",    
                    "previous": "前一页  ",    
                    "next": "  后一页",    
                    "last": "  尾页"         
                 }
          },
          "processing": true, //打开数据加载时的等待效果  
          "serverSide": true,//打开后台分页， 已保证页面在加载时就请求后台  
          "ajax": {  
              "url": "${base}/charge/accRecordList.do",
              "type": "POST"
           },
          
            //datatables select 
           "columnDefs": [ {
               "orderable": false,
               "className": 'select-checkbox',
               "targets":   0
           } ,
           {
               "visible": false,
               "targets": [1]
           }],
           "select": {
               "style":    'os',
               "selector": 'td:first-child'
           },
           "order": [[ 1, 'asc' ]]
	     });
	  
	  //获取到行值
	  /* table.on( 'select', function ( e, dt, type, indexes ) {
		 
		} ); */
	  
  });

  function search1()  
  {  
      table.ajax.reload();  
  }  
  
  //查看
  function viewRecord(){
	  var arr = table.rows({ selected: true });
	  console.log(arr[0].length);
	  if(arr[0].length < 1){
		  tipDiv("请至少选择一条记录");
		  return;
	  }
	  var id = table.rows({ selected: true }).data()[0][1]; 
	  console.log("aaa"+id);
	  window.location.href="${base}/permission/user/getUser.do?id="+id;
  }
  
  
  //提示信息
  function tipDiv(info){
		 var div = $("<div class='alert alert-warning alert-dismissible' id ='tip'></div>");
		 var button = $("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>");
		 var h4 = $("<h4><i class='icon fa fa-warning'></i>提示!</h4>");
		 
		 div.append(button).append(h4).append(info);
		 $("#tips").append(div);
	 }
</script>
</script>

