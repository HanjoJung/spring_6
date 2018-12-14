<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {
	width: 250px;
	height: 250px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = '${param.msg}';
		if (msg != '') {
			alert(msg);
		}

		$("#del").click(function() {
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<h1>Animal Select</h1>

	<h3>num : ${dto.num}</h3>
	<h3>id : ${dto.id}</h3>
	<h3>title : ${dto.title}</h3>
	<h3>kind : ${dto.kind}</h3>
	<h3>name : ${dto.name}</h3>
	<h3>age : ${dto.age}</h3>
	<h3>gender : ${dto.gender}</h3>
	<h3>getDate : ${dto.getDate}</h3>
	<h3>location : ${dto.location}</h3>
	<h3>CONTENTS : ${dto.contents}</h3>
	<div>
		<a href="../resources/ani/${dto.fname}"><img
			alt="${dto.oname}" src="../resources/ani/${dto.fname}">
		</a>
	</div>


	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">update</a>
	<span id="del">delete</span>
	<form id="frm" action="./delete" method="post">
		<input type="hidden" name="num" value="${dto.num}">
	</form>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
</body>
</html>