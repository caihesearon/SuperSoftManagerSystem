<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript"	src="../jquery-easyui-1.7.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.7.0/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.7.0/themes/icon.css" />
<script type="text/javascript" src="../jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-family: "新宋体";
}

.groupbox {
	margin: 3%;
	width: 95%;
	height: 350px;
	border: thin solid rgb(200, 217, 228);
	padding: 10px
}

.grouptitle {
	display: block;
	color: rgb(1, 78, 130);
	margin-top: -22px;
	margin-left: -10px;
	font-family: "楷体";
	width: 100px;
	text-align: center;
	background-color: white
}

.head {
	color: white;
	font-weight: bolder;
	height: 35px;
	background-color: rgb(103, 149, 180);
}

.footer {
	width: 250px;
	margin: auto;
}
</style>
</head>
<body>
	<div class="head">
		<span style="line-height: 35px; margin-left: 20px;"> 任 务 添 加 页 面 </span>
	</div>
	<div class="groupbox">
		<span class="grouptitle">添加任务</span>
		<form id="form1" action="#" method="post">
			<table border="0" cellspacing="10px" style="margin: auto;">
				<tr>
					<td align="right">任务标题:</td>
					<td><input type="text" name="taskTitle" id="taskTitle" /></td>
					<td align="right">工期（天）:</td>
					<td><input type="number" name="taskTime" id="taskTime" /></td>
				</tr>
				<tr>
					<td align="right">计划开始时间:</td>
					<td><input onblur="addEndTime()" type="date" name="taskStartTime"
						id="taskStartTime" value="" /></td>
					<td align="right">计划结束时间:</td>
					<td><input type="date" name="taskEndTime" id="taskEndTime"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">任务执行人:</td>
					<td><select name="userId" id="userId" style="width: 100px;">
							<option value="0">==请选择==</option>
							<option value="1">张三</option>
							<option value="2">李四</option>
							<option value="3">王五</option>
							<option value="4">赵柳</option>
					</select></td>
					<td align="right">优先级:</td>
					<td><select name="taskPriority" id="taskPriority" style="width: 100px;">
							<option value="0">==请选择==</option>
							<option value="高">高</option>
							<option value="中">中</option>
							<option value="低">低</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">任务说明:</td>
					<td colspan="3"><textarea name="taskDesc" id="taskDesc" rows="10" cols="100"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="footer">
		<button class="easyui-linkbutton" data-options="iconCls:'icon-save'"
			style="width: 80px" onclick="addTask()">保存</button>
		<button class="easyui-linkbutton" style="width: 80px; float: right;">返回</button>
	</div>
	<script type="text/javascript">
		function addEndTime() {
			var adate = $("#taskStartTime").val();
			var snum = $("#taskTime").val();
			if (snum == "") {
				return false;
			}
			var num = parseInt(snum);
			var adate = new Date();
			adate.setDate(adate.getDate() + num);
			var y = adate.getFullYear();
			var m = (adate.getMonth() + 1) < 10 ? "0" + (adate.getMonth() + 1)
					: (adate.getMonth() + 1);
			var d = adate.getDate() < 10 ? "0" + adate.getDate() : adate
					.getDate();
			$("#taskEndTime").val(y + "-" + m + "-" + d);
		}
		function addTask(){
			//先获取form表单中的所有数据
			var params = {};
			params.taskTitle = $("#taskTitle").val();
			params.taskTime = parseInt($("#taskTime").val());
			params.taskStartTime = $("#taskStartTime").val();
			params.taskEndTime = $("#taskEndTime").val();
			params.userId = parseInt($("#userId").val());
			params.taskPriority = $("#taskPriority").val();
			params.taskDesc = $("#taskDesc").val();
			//console.log(params);
			$.ajax({
				url:'../task/addtask',
				type:'post',
				dataType:'json',
				data:params,
				success:function(result){
					alert("任务添加成功！！！");
				}
			})
		}
	</script>
</body>
</html>