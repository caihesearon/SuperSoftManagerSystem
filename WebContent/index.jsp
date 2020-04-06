<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"  src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		//alert("Test");
		$("#clk").click(function(){
			//alert("Test");
			//$("#mydiv").empty();
			//window.location.href="controller/test";
			$.ajax({
				url:'controller/test',
				type:'post',
				dataType:'json',
				success:function(data){
					alert(data);
				}
			})
		})
	})
</script>
</head>
<body>
	<a href="controller/queryStudentByNo/1">点击我</a>
<!-- 	<a href="">点击我</a> -->
<!-- 	<img src="/images/图片.png"/> -->
<!-- 	<div> -->
<!-- 		<img src="images/图片.png"> -->
<!-- 	</div> -->
	<h1>index.jsp</h1>
	<div id="mydiv">
		<jsp:include page="/views/result.jsp"></jsp:include>
		${requestScope.test }
	</div>
	<button id="clk" >点击切换为test</button>
	
</body>
</html>