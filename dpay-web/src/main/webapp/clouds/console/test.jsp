<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/clouds/console/common/meta.jsp"%>
<!DOCTYPE HTML>
<head>
<title>流量充值平台-登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<link rel="stylesheet" href="./clouds/console/res/css/toastr.css"  type="text/css">
<style type="text/css">
		body{ margin: 0 auto; font-family: 'Arial', "Hiragino Sans GB", "Microsoft Yahei", 'sans-serif';}
		.topbanner{ width: 100%; height: 50px; background-color: black;}
		.logolabel{ width: 1024px; height: 80px; line-height: 80px; margin: auto; margin-top: 20px;}
		.logolabel span{ font-weight:bold; font-size: 36px; color: black;}
		.panel{ width: 1280px; height: 1659px; background: url("./clouds/console/res/img/index_banner_h.jpg"); margin: auto; background-color: black;}
		/*.panel{ width: 1280px; height: 1659px; background: url("/Public/Assets/Images/index_banner_h.jpg"); margin: auto; background-color: black;}*/
		.login{ background-color: transparent; background-image:  url("./clouds/console/res/img/login_bg.png"); background-repeat: repeat; background-attachment: scroll; background-position: 0% 0%; background-clip: border-box; background-origin: padding-box; background-size: auto auto; width: 484px; height: 359px; position: relative; top: 56px; float: right; right: 80px;} 
		.logininnerdiv1{ color: white; font-size: 31px; padding-top: 22px; padding-left: 50px;}

		.usertf,.passwordtf,.codetf{ background-color: white; width: 370px; height: 50px; margin-left: 50px; margin-top: 15px;}
		.usericon{ background-image: url("./clouds/console/res/img/yonghuming.png"); width: 25px; height: 25px; float: left; margin-top: 11px; margin-left: 11px;}
		.passwordicon{ background-image: url("./clouds/console/res/img/mima.png"); width: 25px; height: 25px; float: left; margin-top: 11px; margin-left: 11px;}
		.codeicon{ background-image: url("./clouds/console/res/img/yanzhengma.png"); width: 25px; height: 25px; float: left; margin-top: 11px; margin-left: 11px;}
		.usertf input, .passwordtf input{ width: 316px; height: 45px; margin-left: 10px; border: medium none; background-color: transparent; background-image: none; background-repeat: repeat;background-attachment: scroll;background-position: 0% 0%;background-clip: border-box;background-origin: padding-box;background-size: auto auto;font-family: "微软雅黑";color: #666;font-size: 16px; line-height: normal; outline:none;}
		.codetf input{ height: 45px; width: 195px; margin-left: 10px; border: medium none; background-color: transparent; background-image: none; background-repeat: repeat;background-attachment: scroll;background-position: 0% 0%;background-clip: border-box;background-origin: padding-box;background-size: auto auto;font-family: "微软雅黑";color: #666;font-size: 16px; line-height: normal; outline:none;}

		.loginbt{ background-color: orange; border: none; width: 183px; height: 46px; line-height: 46px; margin-left: 50px; margin-top: 15px; color: white; font-size: 16px; font-family: "微软雅黑"; cursor: pointer}
		.codetf img{ float: right;}

		.login form a{color: white; margin-left: 20px;}
		.send1{
			cursor: pointer;
			margin-left: 10px;
			color:#030303 ;
			font-size: 10px;
		}
		.send2{
			cursor: pointer;
			margin-left: 10px;
			color:#BABABA ;
			font-size: 10px;
		}
		.send0{
			display: none;
		}
		.code{
			display: block;
		}
		.select_1{
			margin-top: 16px;
			margin-left: 15px;
			height: 30px;
		}
		.btnok{
			margin-left: 10px;
			height: 30px;

		}
	</style>
<script type="text/javascript" src="./clouds/console/res/js/jQuery-2.2.0.min.js" charset="utf-8"></script>
<script type="text/javascript" src="./clouds/console/res/js/jquery-ui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="./clouds/console/res/js/toastr.js" charset="utf-8"></script>
<script type="text/javascript" src="./clouds/console/res/js/layer.js" charset="utf-8"></script>
<script type="text/javascript" src="./clouds/console/res/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="./clouds/console/res/js/com.js"></script>
<link rel="stylesheet" href="./clouds/console/res/css/layer.css" id="layui_layer_skinlayercss">

<script type='text/javascript'>
    $(function(){
    	$(document).keydown(function(event){
    		if(event.keyCode == 13){
    			login();
    		}
    	});
    })

   
	function test(){
		
	   
    	 $.ajax({
             type:"POST",
             url:"http://114.247.0.106:19251/admail/activityPhoneFile/downloadPhoneFile.n",
             data:{"fileName":filename,"fileDataNumber":datacode},
             // url:"http://220.194.48.109:58080/SM/user/register1",
             //crossDomain: true,
            //  data:{"send":"北京"},
             dataType:"jsonp",
             success : function(json){
            	 var da = JSON.stringify(json);
                 alert("dd"+da);
             },
             error:function(json){
            	var da = JSON.stringify(json);
                 alert("ee"+da);
             }
	    });
	}

</script>
</head>
<body>
<div class="topbanner"></div>
<div class="logolabel"> <span>流量充值平台</span> </div>
<div class="panel">
  <div class="login">
    <div class="logininnerdiv1">登录</div>
    <form id="form">
      <div class="usertf">
        <div class="usericon"></div>
        <input type="text" name="username" placeholder="请输入您的账号" id="getAccount" onBlur="javascript:;">
      </div>
      <div class="passwordtf">
        <div class="passwordicon"></div>
        <input type="password" name="password" placeholder="请输入您的密码">
      </div>
      <div class="codetf code" id="showCode">
        <div class="codeicon"></div>
        <input type="text" name="vcode" placeholder="请输入验证码" >
        <img id="loginCaptchaCode" style="width: 120px;height: 50px;" onclick="this.src='./verify/code.do?d='+new Date().getTime();" src="./verify/code.do?d='+new Date().getTime();"  alt="换一张" />
        
      </div>
      <input class="loginbt" type="button" name="submit" onclick="test();" value="登录">
      <input id="returnUrl" name="returnUrl" type="hidden" value="${ReturnUrl}"/>
<!--       <a href="javascript:;">注册</a> <a href="javascript:;">忘记密码?</a> -->
    </form>
  </div>
</div>
</body>
</html>
