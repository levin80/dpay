<%@ page language="java" errorPage="/clouds/console/error.jsp"	pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="/clouds/console/common/taglibs.jsp" %>
<!-- 左侧菜单--> 
  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">我的菜单</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>权限管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="<c:url value='/${path}/permission/user/listpage.do'/>"><i class="fa fa-circle-o"></i> 用户管理</a></li>
            <li><a href="<c:url value='/${path}/permission/role/listpage.do'/>"><i class="fa fa-circle-o"></i> 角色管理</a></li>
            <li><a href="<c:url value='/${path}/permission/perm/listPerm.do'/>"><i class="fa fa-circle-o"></i> 权限管理</a></li>
          </ul>
        </li>
         <li class="treeview">
          <a href="#">
            <i class="fa fa-users"></i> <span>用户管理</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="<c:url value='/${path}/agent/listpage.do'/>"><i class="fa fa-circle-o"></i> 代理商管理</a></li>
          </ul>
        </li>

        <li>
          <a href="<c:url value='/${path}/agent/info.do'/>">
            <i class="fa fa-pie-chart"></i> <span>我的账户</span>
            <small class="label pull-right bg-yellow">4</small>
          </a>
        </li>
         <li>
          <a href="<c:url value='/${path}/charge/toChargePage.do'/>">
            <i class="fa fa-list"></i> <span>加款记录</span>
            <small class="label pull-right bg-yellow">12</small>
          </a>
        </li>
         <li>
          <a href="<c:url value='/${path}/order/toOrderList.do'/>">
            <i class="fa fa-money"></i> <span>产品订单</span>
            <small class="label pull-right bg-yellow">12</small>
          </a>
        </li>
        <li>
          <a href="<c:url value='/${path}/charge/toAccRecordList.do'/>">
            <i class="fa fa-cc-visa"></i> <span>资金记录</span>
            <small class="label pull-right bg-yellow">12</small>
          </a>
        </li>
        <li class="header">常用菜单</li>
        <li><a href="<c:url value='/${path}/charge/accountCharge.do'/>"><i class="fa fa-credit-card"></i> <span>账户加款</span></a></li>
        <li><a href="<c:url value='/${path}/order/paypage.do'/>"><i class="fa fa-database"></i> <span>流量充值</span></a></li>
       
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>