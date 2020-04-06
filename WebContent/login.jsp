<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<script type="text/javascript" src="jquery-easyui-1.7.0/jquery.min.js"></script>
		<style>
			*{
				margin: 0px;
				padding: 0px;
			}
			body{
				font-family: "楷体";
				color: #7F9DB9;
			}
			#container{
				width: 1220px;
				height: 700px;
				margin-right: 10%;
				margin-left: 10%;
				text-align: center;
				overflow: hidden;
				text-align: center;
			}
			#topImg{
				width: 1220px;
				height: 146px;
				margin: 0 auto;
				background-image: url(images/top03.gif);
			}
			#left{
				width: 100px;
				height: 100px;
				margin-top: 100px;
				margin-left: 370px;
				float: left;
				background-image: url(images/ico13.gif);
			}
			#center{
				float: left;
				width: 5px;
				height: 350px;
				margin-left: 80px;
				margin-right: 80px;
				background-image: url(images/line01.gif);
			}
			#right{
				width: 30%;
				height: 400px;
				float: left;
				overflow: hidden;
			}
			table{
				margin-top: 66px;
			}
		</style>
</head>
<body>
	<div id="container">
			<div id="topImg"></div>
			<div id="left">
			</div>
			<div id="center"></div>
			<div id="right">
				<form id="form1" action="##" method="post" onsubmit="return false" >
					<table style="" cellspacing="15px">
						<tr>
							<td align="right"><p>用户名称:</p></td>
							<td align="left"><input type="text"  size="25" id="userName" name="userName" required /></td>
						</tr>
						<tr>
							<td align="right"><p>密码:</p></td>
							<td align="left"><input type="password" size="25" id="userPwd" name="userPwd" required /></td>
						</tr>
						<tr>
							<td align="right"><p>验证图片:</p></td>
							<td align="left">图</td>
						</tr>
						<tr>
							<td align="right">请输入验证码:</td>
							<td align="left"><input type="text" size="25" /></td>
						</tr>
						<tr>
							<td></td>
							<td align="left">
								<button id="btnLogin" type="button" onclick="login()" style="width:63px;height:20px;border:none;font-family: '楷体';background-image: url(images/button03.gif);">确认登录</button>
								<input style="width:63px;height:20px;border:none;font-family: '楷体';background-image: url(images/button03.gif);" type="reset" value="重置" />
							</td>
						</tr>
					</table>
					
				</form>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					url:'user/checklogin',
					type:'post',
					success:function(result){
						if(result.status == 200){
							//跳转到主页
							window.location.href="views/managerPage.jsp";
						}
					}
				})
			})
		
		
			function login(){
				var params = {};
				params.userName = $("#userName").val();
				params.userPwd = $("#userPwd").val();
				$.ajax({
					url:'user/login',
					type:'post',
					dataType:'json',
					data:params,
					success:function(result){
// 						console.log(result);
						//登录成功
						if(result.status == 200){
							//跳转到主页
							window.location.href="views/managerPage.jsp";
						//登录失败
						}else{
							//弹出提示框
							alert("账号或者密码错误");
						}
					}					
				})
			}
			
		</script>	
</body>
</html>