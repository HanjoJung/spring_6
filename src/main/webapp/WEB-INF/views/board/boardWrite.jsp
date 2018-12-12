<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.files, .del {
	color: red;
	cursor: pointer;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var file = '<div><input type="file" name="f1"><span class="files">X</span></div>';
		var count = 0;
		$("#fileAdd").click(function() {
			if (count < 5) {
				$("#files").append(file);
				count++;
			} else {
				alert("파일은 5개까지만 등록가능합니다");
			}
		})
		
		$("#files").on("click", ".files", function() {
			$(this).parent().remove();
			count--;
		})

	})
</script>
</head>
<body>
	<h1>${board}Write</h1>

	<form action="./${board}Write" method="post"
		enctype="multipart/form-data">
		<input type="text" name="title"> <input type="text"
			name="writer">
		<textarea name="contents" rows="" cols=""></textarea>
		<div id="files"></div>
		<input id="fileAdd" type="button" value="ADD">
		<button>Write</button>
	</form>


</body>
</html>