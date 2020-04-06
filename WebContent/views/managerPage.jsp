<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理页面</title>
<script type="text/javascript" src="../jquery-easyui-1.7.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.7.0/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.7.0/themes/icon.css" />
<script type="text/javascript" src="../jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
	body {
		font-family: microsoft yahei;
	}
	#container{
		width: 1600px;
		height: 100%;
		margin: 0 auto;
	}
	.tree-node {
		margin-left: 25px;
		padding-left: 25px;
		color: #222D32;
		font-family: "楷体";
		font-weight: bold;
	}
	#userInfo{
		width: 100%;
		height: 80px;
		background-image: url(../images/nav01.gif);
		background-size: 100% 100%;
		background-repeat:no-repeat;
	}
	.myImg{
		width: 50px;
		height: 50px;
		background-image: url(../images/ico02.gif);
		background-size: 50px 50px;
		background-repeat:no-repeat;
		margin-top: 15px;
		margin-left: 28px;
		float: left;
	}
	.myName{
		width: 220px;
		height: 60px;
		float: right;
		margin-top: 10px;
		margin-right: 28px;
	}
</style>
</head>
<body class="easyui-layout" id="container">

<!-- 	<h1>管理页面</h1> -->
<!-- 	<h1>Name： -->
<!-- 		<div id="myName"> -->
		
<!-- 		</div> -->
<!-- 	</h1> -->
<!-- 	<a href="test.jsp">test</a> -->
<!-- 	<a href="../login.jsp">登录</a> -->
<!-- 	<button id="btn">退出</button> -->

	<div data-options="region:'north'" style="width:100%;height:105px;overflow: hidden; background-image: url(../images/top001.png);background-size:100% 100%;background-repeat:no-repeat;">
	</div>
	<div region="south" style="height: 25px;padding: 5px" align="center">
		阿河的Java-Web项目开发 版权所有
	</div>
	<div data-options="region:'west',title:'导航菜单'" style="width:350px;">
		<div id="userInfo">
			<div class="myImg">
			</div>
			<div  class="myName">
				<div  style="margin-bottom:15px;color: rgb(68,140,203);font-size: 18px;font-family: 'lucida console';font-weight: bold;">您好，<block id="myName"></block></div>
				<button id="outLogin" style="color: rgb(68,140,203); border: none;background: none;font-size: 16px;font-family: 'lucida console';">[ 退出 ]</button>
			</div>
		</div>
		<div id="sm" class="easyui-sidemenu" data-options="data:data,onSelect:updateTab,multiple:false" style="width: 348px;"></div>
	
	</div>
	<div data-options="region:'center'" style="background:#eee;">
		<div id="tt" class="easyui-tabs" style="height: 100%;">
			<div title="首页" id="tab1" style="display:none;background-image: url(../images/welcome.gif);background-repeat:no-repeat;background-size:100% ">
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:'../user/checklogin',
				type:'post',
				success:function(result){
					if(result.status == 500){
						//跳转到登录页面
						window.location.href="../login.jsp";
					}
					$("#myName").append(result.data.userName);
				}
			});
		});
		
		$("#outLogin").click(function(){
			$.ajax({
				url:'../user/outlogin',
				type:'post',
				success:function(result){
					if(result.status == 200){
						//跳转到登录页面
						window.location.href="../login.jsp";
						//重新加载此页面  --- 两种方式都可以
						//window.location.reload();
					}
				}
			})
		});
		
		function updateTab(item) {
			var url = item.url;
			var text = item.text;
			//需要根据用户的类型来判断是否可以进行相应的操作
			$("#tab1").css("background-image", "none");
			var ctab = $('#tt').tabs('getSelected'); // 获取选择的面板
			$('#tt').tabs('update', {
				tab: ctab,
				options: {
					title: text,
					content: "<iframe scrolling='auto' frameborder='0'  src='" + url + "' style='width:100%;height:100%;'></iframe>"
				}
			});
		}
		var data = [{
			text: '任务管理',
			// iconCls: 'icon-test',
			//          state: 'open',
			children: [{
				text: '创建任务',
				url: 'addTask.jsp',
			}, {
				text: '任务信息查看',
				url: '../test2.html'
			}]
		}, {
			text: '项目系统',
			children: [{
				text: '项目基本信息查看',
				url: ''
			}, {
				text: '项目计划信息查看',
				url: ''
			}, {
				text: '项目需求信息查看',
				url: ''
			}, {
				text: '项目模块信息查看',
				url: ''
			}, {
				text: '项目功能信息查看',
				url: ''
			}, {
				text: '项目上传信息查看',
				url: ''
			}, {
				text: '项目成本信息查看',
				url: ''
			}]
		}, {
			text: '人员系统',
			children: [{
				text: '人员信息查看',
				url: ''
			}, {
				text: '职务信息查看',
				url: ''
			}, {
				text: '员工工作情况查看',
				url: ''
			}]
		}, {
			text: '考勤系统',
			children: [{
				text: '考勤类型查看',
				url: ''
			}, {
				text: '员工考勤信息查看',
				url: ''
			}]
		}];
		
	</script>
</body>
</html>