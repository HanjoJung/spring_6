<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			$.get("./jtest2", function(data) {
				alert(data);
			});
		})
		$("#btn").click(function() {
			$.ajax({
				url : "./list",
				success : function(data) {
					console.log(data);
					$.each(data,function(index, data) {
						console.log(data.num);
					});
				}
			});
		})
	})
</script>
</head>
<body>
	<h1>Mamo List</h1>
	<div id="list"></div>
	<button type="button" id="btn">List</button>
	<button type="button" id="btn1">JSON</button>

</body>
</html>