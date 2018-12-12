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

.files, .del {
	color: red;
	cursor: pointer;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var count = ${files.size()};
		var index = 0;
		$("#btn").click(function() {
			var file = "<div id='a"+index+"'><input type='file' name='f1'><span title='a"+index+"' class='del'>X</span></div>";
			if (count < 5) {
				$("#addFile").append(file);
			} else {
				alert("파일은 최대 5개까지만 가능합니다");
			}
			count++;
			index++;
		});
		
		$("#addFile").on("click", ".del", function() {
			$(this).parent().remove();
			count--;
		});
		
		$(".files").click(function() {
			var id = $(this).attr("id");
			var del = $(this).attr("title");
			$.ajax({
				url : "../file/delete",
				tayp : "POST",
				data : {
					fnum : id
				},
				success : function(data) {
					data = data.trim();
					if (data == 1) {
						count--;
						$("#" + del).remove();
					} else {
						alert("파일 삭제 실패");
					}
				}
			})
		});
	})
</script>
</head>
<body>
	<h1>${board}Update</h1>

	<form action="./${board}Update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num}"> <input
			type="text" name="title" value="${dto.title}"> <input
			type="text" name="writer" value="${dto.writer}">
		<textarea name="contents" rows="" cols="">${dto.contents}</textarea>
		<div id="addFile"></div>
		<div>
			<c:forEach items="${files}" var="file" varStatus="i">
				<div id="f${i.index}">
					<span> <img alt="${file.oname}"
						src="../resources/${board}/${file.fname}"> ${file.oname}
					</span>
					<span title="f${i.index}" class="files" id="${file.fnum}">X</span>
				</div>
			</c:forEach>
		</div>
		<button type="button" id="btn">Add</button>
		<button>Update</button>
	</form>

</body>
</html>