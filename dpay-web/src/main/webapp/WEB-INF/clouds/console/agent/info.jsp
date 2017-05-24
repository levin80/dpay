<%@ include file="/clouds/console/common/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datatables/media/css/dataTables.bootstrap.min.css'/>" >
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datatables/extensions/Select/css/select.dataTables.min.css'/>" >
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/all.css'/>" >
<!-- iCheck -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/iCheck/flat/blue.css'/>" >
  <!-- Morris chart -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/morris/morris.css'/>" >
  <!-- jvectormap -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/jvectormap/jquery-jvectormap-1.2.2.css'/>" >
  <!-- Date Picker -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/datepicker/datepicker3.css'/>" >
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/daterangepicker/daterangepicker-bs3.css'/>" >
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="<c:url value='/clouds/console/res/plugins/bootstrapwysihtml5/bootstrap3-wysihtml5.min.css'/>" >






<div class="row">
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-aqua"><i class="fa fa-dollar"></i></span>
      <div class="info-box-content"> <span class="info-box-text">总销售额</span> <span class="info-box-number">￥198000000</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-aqua"><i class="fa fa-cny"></i></span>
      <div class="info-box-content"> <span class="info-box-text">总成本</span> <span class="info-box-number">￥230000</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <!-- fix for small devices only -->
  <div class="clearfix visible-sm-block"></div>
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-green"><i class="fa fa-bitcoin"></i></span>
      <div class="info-box-content"> <span class="info-box-text">账户余额</span> <span class="info-box-number">￥760.00</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-green"><i class="fa fa-money"></i></span>
      <div class="info-box-content"> <span class="info-box-text">赠送金额</span> <span class="info-box-number">￥2000.16</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
   <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-red"><i class="fa fa-eur"></i></span>
      <div class="info-box-content"> <span class="info-box-text">总利润</span> <span class="info-box-number">￥198000000</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-yellow"><i class="fa fa-rub"></i></span>
      <div class="info-box-content"> <span class="info-box-text">二级代理销售额</span> <span class="info-box-number">￥230000</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <!-- fix for small devices only -->
  <div class="clearfix visible-sm-block"></div>
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-yellow"><i class="fa fa-ils"></i></span>
      <div class="info-box-content"> <span class="info-box-text"></span> 二级代理成本<span class="info-box-number">￥760.00</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
  <!-- /.col -->
  <div class="col-md-3 col-sm-6 col-xs-12">
    <div class="info-box"> <span class="info-box-icon bg-yellow"><i class="fa fa-gbp"></i></span>
      <div class="info-box-content"> <span class="info-box-text">二级代理月利润</span> <span class="info-box-number">￥2000.16</span> </div>
      <!-- /.info-box-content -->
    </div>
    <!-- /.info-box -->
  </div>
</div>
<div class="row">
  <!-- Left col -->
  <section class="col-lg-7 connectedSortable ui-sortable">
  <!-- Custom tabs (Charts with tabs)-->
  <!-- /.nav-tabs-custom -->
            <div class="nav-tabs-custom">
            <!-- Tabs within a box -->
            <ul class="nav nav-tabs pull-right">
              <li class="active"><a href="#revenue-chart" data-toggle="tab">Area</a></li>
              <li><a href="#sales-chart" data-toggle="tab">Donut</a></li>
              <li class="pull-left header"><i class="fa fa-inbox"></i> 销售量（元）</li>
            </ul>
            <div class="tab-content no-padding">
              <!-- Morris chart - Sales -->
              <div class="chart tab-pane active" id="revenue-chart" style="position: relative; height: 300px;"></div>
              <div class="chart tab-pane" id="sales-chart" style="position: relative; height: 300px;"></div>
            </div>
          </div>
  <!-- Chat box -->
  
    </section>
    <!-- right col -->
    <section class="col-lg-5 connectedSortable ui-sortable">
      <!-- solid sales graph -->
      <div class="box box-solid bg-teal-gradient">
        <div class="box-header ui-sortable-handle" style="cursor: move;"> <i class="fa fa-th"></i>
          <h3 class="box-title">利润图</h3>
          <div class="box-tools pull-right">
            <button type="button" class="btn bg-teal btn-sm" data-widget="collapse"><i class="fa fa-minus"></i> </button>
            <button type="button" class="btn bg-teal btn-sm" data-widget="remove"><i class="fa fa-times"></i> </button>
          </div>
        </div>
        <div class="box-body border-radius-none">
          <div class="chart" id="line-chart" style="height: 250px; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
            <svg height="250" version="1.1" width="375" xmlns="http://www.w3.org/2000/svg" style="overflow: hidden; position: relative; left: -0.65625px; top: -0.59375px;">
              <desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.0</desc>
              <defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="48.5" y="213" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">0</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,213H350" stroke-width="0.4"></path>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="48.5" y="166" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">5,000</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,166H350" stroke-width="0.4"></path>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="48.5" y="119" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">10,000</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,119H350" stroke-width="0.4"></path>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="48.5" y="72" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">15,000</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,72H350" stroke-width="0.4"></path>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="48.5" y="25" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">20,000</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,25H350" stroke-width="0.4"></path>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="296.97569866342644" y="225.5" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal" transform="matrix(1,0,0,1,0,6)">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2013</tspan>
              </text>
              <text style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 10px; line-height: normal; font-family: &quot;Open Sans&quot;;" x="168.45321992709597" y="225.5" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#ffffff" font-size="10px" font-family="Open Sans" font-weight="normal" transform="matrix(1,0,0,1,0,6)">
                <tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2012</tspan>
              </text>
              <path style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" fill="none" stroke="#efefef" d="M61,187.93959999999998C69.07654921020657,187.6764,85.22964763061968,189.52585,93.30619684082625,186.8868C101.38274605103281,184.24775,117.53584447144593,167.99562513661203,125.61239368165249,166.8272C133.60115431348726,165.67147513661203,149.57867557715673,179.82035,157.5674362089915,177.59019999999998C165.55619684082626,175.36004999999997,181.53371810449573,151.209806284153,189.5224787363305,148.986C197.59902794653706,146.737756284153,213.75212636695016,157.36375,221.82867557715673,159.702C229.9052247873633,162.04025000000001,246.05832320777643,178.80089945355192,254.134872417983,167.692C262.1236330498177,156.70384945355192,278.10115431348726,78.24561187845303,286.089914945322,71.31379999999999C293.99088699878496,64.45816187845303,309.7928311057108,104.82477417582417,317.69380315917374,112.5422C325.7703523693803,120.43112417582418,341.92345078979343,128.43994999999998,350,133.73919999999998" stroke-width="2"></path>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="61" cy="187.93959999999998" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="93.30619684082625" cy="186.8868" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="125.61239368165249" cy="166.8272" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="157.5674362089915" cy="177.59019999999998" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="189.5224787363305" cy="148.986" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="221.82867557715673" cy="159.702" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="254.134872417983" cy="167.692" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="286.089914945322" cy="71.31379999999999" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="317.69380315917374" cy="112.5422" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
              <circle style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);" cx="350" cy="133.73919999999998" r="4" fill="#efefef" stroke="#efefef" stroke-width="1"></circle>
            </svg>
            <div class="morris-hover morris-default-style" style="left: 149.679px; top: 103px; display: none;">
              <div class="morris-hover-row-label">2011 Q4</div>
              <div class="morris-hover-point" style="color: #efefef"> Item 1:
                3,767 </div>
            </div>
          </div>
        </div>
       
      </div>
      <!-- /.box -->
      <!-- Calendar -->
    </section>
  </div>
  
  
  <div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">区域运营商当月利润</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <div class="btn-group">
                  <button type="button" class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown">
                    <i class="fa fa-wrench"></i></button>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="row">
                <div class="col-md-8">
                  <p class="text-center">
                    <strong>利润情况: 2015.08.01 - 2016.07.31</strong>
                  </p>

                  <div class="chart">
                    <!-- Sales Chart Canvas -->
                    <canvas id="salesChart" style="height: 180px;"></canvas>
                  </div>
                  <!-- /.chart-responsive -->
                </div>
                <!-- /.col -->
                <div class="col-md-4">
                  <p class="text-center">
                    <strong>利润/用户量</strong>
                  </p>

                  <div class="progress-group">
                    <span class="progress-text">所有</span>
                    <span class="progress-number"><b>36088.02</b>/25000</span>

                    <div class="progress sm">
                      <div class="progress-bar progress-bar-aqua" style="width: 54%"></div>
                    </div>
                  </div>
                  <!-- /.progress-group -->
                  <div class="progress-group">
                    <span class="progress-text">移动</span>
                    <span class="progress-number"><b>2500.01</b>/12000</span>

                    <div class="progress sm">
                      <div class="progress-bar progress-bar-red" style="width: 78%"></div>
                    </div>
                  </div>
                  <!-- /.progress-group -->
                  <div class="progress-group">
                    <span class="progress-text">联通</span>
                    <span class="progress-number"><b>1100.68</b>/7000</span>

                    <div class="progress sm">
                      <div class="progress-bar progress-bar-green" style="width: 56%"></div>
                    </div>
                  </div>
                  <!-- /.progress-group -->
                  <div class="progress-group">
                    <span class="progress-text">电信</span>
                    <span class="progress-number"><b>1000.31</b>/6000</span>

                    <div class="progress sm">
                      <div class="progress-bar progress-bar-yellow" style="width: 45%"></div>
                    </div>
                  </div>
                  <!-- /.progress-group -->
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div>
            <!-- ./box-body -->
            <div class="box-footer">
              <div class="row">
                <div class="col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <span class="description-percentage text-green"><i class="fa fa-caret-up"></i> 100%</span>
                    <h5 class="description-header">￥35210.43</h5>
                    <span class="description-text">总利润</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <span class="description-percentage text-yellow"><i class="fa fa-caret-left"></i> 56%</span>
                    <h5 class="description-header">￥10390.90</h5>
                    <span class="description-text">移动</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-3 col-xs-6">
                  <div class="description-block border-right">
                    <span class="description-percentage text-green"><i class="fa fa-caret-up"></i> 23%</span>
                    <h5 class="description-header">￥24813.53</h5>
                    <span class="description-text">联通</span>
                  </div>
                  <!-- /.description-block -->
                </div>
                <!-- /.col -->
                <div class="col-sm-3 col-xs-6">
                  <div class="description-block">
                    <span class="description-percentage text-red"><i class="fa fa-caret-down"></i> 21%</span>
                    <h5 class="description-header">￥1200.02</h5>
                    <span class="description-text">电信</span>
                  </div>
                  <!-- /.description-block -->
                </div>
              </div>
              <!-- /.row -->
            </div>
            <!-- /.box-footer -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
  <script src="<c:url value='/clouds/console/res/plugins/datatables/media/js/jquery.dataTables.min.js'/>"></script> 
  <script src="<c:url value='/clouds/console/res/plugins/datatables/media/js/dataTables.bootstrap.min.js'/>"></script>
  
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value='/clouds/console/res/js/jquery-ui.min.js'/>"></script>

<script src="<c:url value='/clouds/console/res/js/raphael-min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/morris/morris.min.js'/>"></script>
<!-- Sparkline -->
<script src="<c:url value='/clouds/console/res/plugins/sparkline/jquery.sparkline.min.js'/>"></script>
<!-- jvectormap -->
<script src="<c:url value='/clouds/console/res/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value='/clouds/console/res/plugins/knob/jquery.knob.js'/>"></script>
<!-- daterangepicker -->
<script src="<c:url value='/clouds/console/res/js/moment.min.js'/>"></script>
<script src="<c:url value='/clouds/console/res/plugins/daterangepicker/daterangepicker.js'/>"></script>
<!-- datepicker -->
<script src="<c:url value='/clouds/console/res/plugins/datepicker/bootstrap-datepicker.js'/>"></script>

<!-- Bootstrap WYSIHTML5 -->
<script src="<c:url value='/clouds/console/res/plugins/bootstrapwysihtml5/bootstrap3-wysihtml5.all.min.js'/>"></script>
<!-- ChartJS 1.0.1 -->
<script src="<c:url value='/clouds/console/res/plugins/chartjs/Chart.min.js'/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value='/clouds/console/res/js/dashboard2.js'/>"></script>
<script src="<c:url value='/clouds/console/res/js/dashboard.js'/>"></script>


