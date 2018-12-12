<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Update</h1>
	
	<form action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		<input type="text" name="title" value="${dto.title}">
		<input type="text" name="writer" value="${dto.writer}">
		<textarea name="contents" rows="" cols="">${dto.contents}</textarea>
		<button>Update</button>
	</form>

</body>
</html>