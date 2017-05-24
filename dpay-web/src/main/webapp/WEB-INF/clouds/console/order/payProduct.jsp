<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<script type="text/javascript">
 $(function(){
	/*  $("#btn").click(function(){
			var table = document.getElementById("form22");
			table.submit();
		}); */
 });
 function changeStatus(obj){
	 $(obj).css({'background-color':'#f39c12','color':'#fff'}).siblings().css({'background-color':'#f4f4f4','color':'#666'});
	 $(".productname").text($(obj).attr("i"));
	 $(".productdesc b").text($(obj).attr("lang"));
	 $("#dpn").text($(obj).attr("i"));
	 var skuid = $(obj).attr("id");
	 $("#skuId").attr("value",skuid);
 }


 </script>
 <style>
.btn-app {margin: 10px 6px;height: 50%; padding:8px 2px;}
.btn-app div{font-size:15px;}
.productname {margin-top: 20px;color:#f39c12;}
.productdesc {margin-top: 10px;}
.productdesc font {color:#dd4b39;}

    .example-modal .modal {
      position: relative;
      top: auto;
      bottom: auto;
      right: auto;
      left: auto;
      display: block;
      z-index: 999;
      vertical-align: middle;
    }

.example-modal .modal {
      background: transparent !important;
    }
</style>
<div class="box box-info">
  <div class="box-header with-border">
    <h3 class="box-title">流量充值</h3>
  </div>
  <!-- form start -->
  <form class="form-horizontal" id="form22" name="form1"  action="${base}/order/pay.do" method="post">
    <div class="box-body">

      <div class="btn-group">
       <c:forEach items='${plist}' var="p">
           <a class="btn btn-app" onclick = "changeStatus(this);" lang="${p.skuPrice/100}" i="${p.shortName}" id="${p.skuId}"><div>${p.skuName}</div></a>
      </c:forEach>
     </div>
     <div class="productname"></div>
     <div class="productdesc">代理价：<b></b>元，充值手机号：<font class="phone">${phone}</font></div>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
      <button type="button" class="btn btn-info pull-left"  onclick="javascript:window.location.href='${base}/order/paypage.do'">重填号码</button>
      <button type="button" id="btn" class="btn btn-warning pull-left" style="margin-left: 20px;" data-toggle="modal" data-target="#myModal" > 立即充值</button>
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

<!-- 模态框 -->
<div class="modal fade example-modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal modal-warning">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">流量充值</h4>
              </div>
              <div class="modal-body">
                <p>您正在为手机号【${phone}】充值【<b id ="dpn"> </b>】，是否立即充值？</p>
                 <input type="hidden" id="skuId" name="skuId" value="" />
                 <input type="hidden" id="phone" name="phone" value="${phone}" />
              </div>
              <div class="modal-footer">
                 <button type="button" class="btn btn-outline " onclick="pay();">立即充值</button>
                <button type="button" class="btn btn-outline pull-right" data-dismiss="modal" style="margin-left: 20px;">取消</button> 
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
</div>

<script type='text/javascript'>

	function pay(){
		var phone = $("#phone").attr("value");
		var skuId = $("#skuId").attr("value");
	    
	    var params = {
	    		phone: phone,
	    		skuId: skuId
	        }
	    var url = $("#form22").action;
	    console.log(url);
	    $.ajax({
	    	type: "POST",
			contentType: "application/json; charset=utf-8",
			url:getRootPath() + "/console/order/pay.do",
			async: false,
			data: JSON.stringify(params),
			complete:function(data){
				var obj = eval('(' + data.responseText + ')');
				console.log(obj);
				  window.location.href = getRootPath() + "/console/order/paypage.do";
			 }
		  })
	}

</script>
