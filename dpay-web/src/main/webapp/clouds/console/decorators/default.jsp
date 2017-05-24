<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/clouds/console/common/taglibs.jsp" %>
<%
    String basePath = (String)request.getAttribute("system");
    if (basePath != null){
        basePath = "clouds/console";
    }
%>
<c:set var="path" value="<%=basePath %>" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Boxed Layout</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/bootstrap/css/bootstrap.min.css'/>" >
<!-- Font Awesome -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/css/font-awesome.min.css'/>" >
<!-- Ionicons -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/css/ionicons.min.css'/>" >
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/css/AdminLTE.css'/>" >
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/css/skins/_all-skins.min.css'/>" >
<!-- jQuery 2.2.0 -->
<script src="<c:url value='/clouds/console/res/js/jquery-1.10.2.js'/>"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<c:url value='/clouds/console/res/bootstrap/js/bootstrap.min.js'/>"></script>
<!-- SlimScroll -->
<script src="<c:url value='/clouds/console/res/plugins/slimScroll/jquery.slimscroll.min.js'/>"></script>
<!-- FastClick -->
<script src="<c:url value='/clouds/console/res/plugins/fastclick/fastclick.js'/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/clouds/console/res/js/app.min.js'/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value='/clouds/console/res/js/demo.js'/>"></script>
<script src="<c:url value='/clouds/console/res/js/com.js'/>"></script>
</head>
<!-- ADD THE CLASS layout-boxed TO GET A BOXED LAYOUT -->
<body class="sidebar-mini wysihtml5-supported layout-boxed skin-yellow-light" 
<decorator:getProperty property="body.id" writeEntireProperty="true"/>
<decorator:getProperty property="body.class" writeEntireProperty="true"/>
>
<!-- Site wrapper -->
<div class="wrapper">
  <jsp:include page="/clouds/console/common/header.jsp"/>
  <jsp:include page="/clouds/console/common/menu.jsp"/>
  <!-- 右侧内容-->
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1> 通知： <small>依据运营商流量业务管理规范，禁止收淘宝，天猫代理单，查实封账户，望知悉！！</small> </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主菜单</a></li>
        <li><a href="#">权限管理</a></li>
        <li class="active">用户管理</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content">
      <decorator:body/>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <jsp:include page="/clouds/console/common/footer.jsp"/>
</div>
<!-- ./wrapper -->
</body></html>
