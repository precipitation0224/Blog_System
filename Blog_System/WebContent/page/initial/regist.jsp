<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>欢迎登录BLog_System</title>
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">  
	<link type="text/css" rel="stylesheet" href="../../css/regist.css">
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script>  
	var app = angular.module('myApp', []);  
	app.controller('registerCtrl', function($scope) {  
  
	});  
	</script> 
	</head>
	<body onload="document.getElementById('user').focus()">
		<div class="regist_block">
			<p id="#regist_logo"><img src="../../image/logo.png" width="70px" height="48.3px"></p>
			<div ng-app="myApp" ng-controller="registerCtrl">
			<form action="regist" method="POST" name="registerForm" novalidate>
				<span id="span1" class="label label-success" style="display: none">用户名可用</span>
				<span id="span2" class="label label-danger" style="display: none">用户名不可用</span>				
				<p><label class="lable_input">请输入账号：</label>
					<input type="text" name="user_name" id="user" class="text_input" ng-model="user" placeholder="请输入您的账号"><br/></p>
					<p><span style="color: red" ng-show=" registerForm.user.$invalid">
					</span></p>
				<p><label class="lable_input">请输入密码：</label>
					<input type="password" name="user_password1" class="text_input" ng-model="user_password1" ng-minlength="8" ng-maxlength="20" placeholder="请输入您的密码"><br/></p>
					<p><span style="color: red" ng-show="registerForm.user_password1.$invalid">
					<span ng-show="registerForm.user_password1.$error.minlength">*密码长度不小于8</span>
					<span ng-show="registerForm.user_password1.$error.maxlength">*密码长度不超过20</span>
					</span></p>
				<p><label class="lable_input">请确认密码：</label>
					<input type="password" name="user_password2" class="text_input" ng-model="user_password2" placeholder="重复输入密码" ></p>
					<p><span style="color: red" ng-show="registerForm.user_password1.$valid">
					<span ng-show="user_password2!=user_password1">*两次密码输入不一致</span>
					</span></p>
				<p><label class="lable_input">请输入邮箱：</label>
					<input type="email" name="user_text" id="email" placeholder="请输入您的邮箱"><br/></p>
				<p><label class="lable_input">输入验证码：</label>
					<input type="text" name="yanzhengma" class="text_input" placeholder="请输入邮箱验证码">
					<input type="button" id="btn" value="获取验证码" onclick="settime(this)" /></p>
				<div id="regist_control">
					<input type="submit" value="注册">
					<input type="reset" value="重置"/>
				</div>
			</form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	var countdown = 60;
	function settime(obj) {
	    if (countdown == 0) {
	        obj.removeAttribute("disabled");
	        obj.value="免费获取验证码";
	        countdown = 60;
	        return;
	    } else {
	        obj.setAttribute("disabled", true);
	        obj.value="重新发送(" + countdown + ")";
	        countdown--;
	    }
	setTimeout(function() {
	    settime(obj) }
	    ,1000)
	}
	</script>
	<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			if($("#email").val()){
				$.ajax({
					type:'POST',
					url :'send_email',
					data:{
						email:$("#email").val(),
					},
					success:function(data){
						alert("验证码发送成功，请注意查收。");
					},
				})
			}
		});
	})
	</script>
</html>