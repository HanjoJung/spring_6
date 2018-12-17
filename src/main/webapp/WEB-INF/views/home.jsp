<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").click(function() {
			var f = $("#f")[0];
			var formData = new FormData(f);

			$.ajax({
				url : "notice/noticeWrite",
				type : "POST",
				processData : false,
				contentType : false,
				data : formData,
				seccess : function(data) {
					data = data.trim();
					alert(data);
					alert("성공")
				},
				error : function(xhr) {
					alert(xhr.statusText);
				}
			})
		})
	})
</script>
</head>
<body>
	<h1>Hello world!</h1>
	<div>
		<form action="./notice/noticeWrite" method="post" id="f">
			<input type="text" id="writer" name="writer"> 
			<input type="text" id="title" name="title">
			<textarea rows="" cols="" id="contents" name="contents"></textarea>
			<input type="button" value="Write" id="frm">
		</form>
	</div>

	<P>The time on the server is ${serverTime}.</P>
	<a href="./notice/noticeList">Notice List</a>
	<a href="./qna/qnaList">Qna List</a>
	<a href="./ani/list">Animal List</a>
	<a href="./memo/memoList">Memo</a>
	<c:choose>
		<c:when test="${not empty member}">
			<p>
				<a href="./member/logOut">LogOut</a> 
				<a href="./member/myPage">myPage</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="./member/join">Join</a> 
				<a href="./member/login">Login</a>
			</p>
		</c:otherwise>
	</c:choose>

</body>
</html>
