<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/clouds/console/common/taglibs.jsp" %>
<%
    String basePath = (String)request.getAttribute("system");
    if (basePath != null&&basePath.indexOf("pms")!=-1){
        basePath = "clouds/console";
    }
    String pmsImgPath = "pms";
%>
<c:set var="path" value="<%=basePath %>" scope="session"/>
<c:set var="pmsImgPath" value="<%=pmsImgPath %>" scope="page"/>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/clouds/console/common/meta.jsp" %>
    <title><fmt:message key='webapp.name'></fmt:message></title>

    <link rel="icon" type="image/x-icon" href="<c:url value='/clouds/console/res/imgs/favicon.ico'/>" />
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/clouds/console/res/imgs/favicon.ico'/>" />

    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/clouds/console/scripts/dtree/dtree.css'/>" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/pms/template/res/css/template.css'/>" />
    
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/pms/template/res/css/buy.css'/>" />
    <!-- bootstrap.css需要在buy.css 下面 -->
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/pms/template/res/css/bootstrap.css'/>" />
      <!-- bootstrap的时间控件CSS-->
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/pms/template/res/datepicker/css/datepicker.css'/>" /> 
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/pms/template/res/datepicker/css/datepicker.min.css'/>" /> 
    <!-- style.css需要在bootstrap.css 下面 -->
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/clouds/console/res/css/style.css'/>" />
    <script language="javascript" type="text/javascript" src="<c:url value='/clouds/console/res/js/jquery-1.10.2.js'/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/clouds/console/res/js/com.js'/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/clouds/console/res/js/many_form_validator.js'/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/clouds/console/res/js/jquery.md5.js'/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/pms/template/res/js/bootstrap.min.js'/>"></script>
    
     <!-- bootstrap的时间控件JS-->
    <script language="javascript" type="text/javascript" src="<c:url value='/pms/template/res/datepicker/js/bootstrap-datepicker.js'/>"></script>
    <script language="javascript" type="text/javascript" src="<c:url value='/pms/template/res/datepicker/js/bootstrap-datepicker.zh-CN.js'/>"></script>
    
    <script src="<c:url value='/pms/template/res/js/tab.js'/>"></script>
    <script src="<c:url value='/pms/template/res/js/picauto.js'/>"></script>
<%--    <script src="<c:url value='/pms/template/res/js/lrtk2.js'/>"></script>用吗？需要的话放开注释时备注下哦--%>


    <script>
        function pbf(name,start){
            $("#"+name).progressBar({
                increment:1, //定义增长率
                width:260,	//定义宽度，请不要更改！
                height:17,	//定义高度，请不要更改！
                cpercentage: start,
                boxImage: '${base }/res/imgs/progressbox.gif',	//危险，不要更改文件名！这两个图在img目录下，路径要改动的话可以配。
                barImage: '${base }/res/imgs/progressbar.gif'		//危险，不要更改！
                //还有几个属性：showText：默认为true，表示显示那个文字。
            });
        }
    </script>
    <decorator:head/></head>

<body <decorator:getProperty property="body.id" writeEntireProperty="true"/> <decorator:getProperty property="body.class" writeEntireProperty="true"/>>

<div class="header">
    <jsp:include page="/clouds/console/common/header.jsp"/>
    <jsp:include page="/clouds/console/common/menu.jsp"/>
</div>
<div class="main">
    <decorator:body/>
</div>

<div class="footer">
<jsp:include page="/clouds/console/common/footer.jsp"/>
</div>

<div id="confirm" class="alt" style="display:none">
    <div class="t"></div>
    <div class="c set">
        <h2 title="系统提示">系统提示</h2>
        <div id="confirmClose" class="o" title="关闭"></div>
        <p class="alg_c">操作确认?</p>
        <p class="alg_c"><input type="button" id="confirmOk" onclick="d('dd');" value="确 定" class="hand btn83x23" /><input type="button" value="取 消" id="confirmReset" class="hand btn83x23b" /></p>
    </div>
    <div class="f"></div>
</div>


</body>
</html>
