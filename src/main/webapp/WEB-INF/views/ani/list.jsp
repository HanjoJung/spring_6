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
	width: 50px;
	height: 50px;
}
</style>
<script type="text/javascript">
	var msg = '${param.msg}';
	if (msg != '') {
		alert(msg);
	}
</script>
</head>
<body>
	<h1>Animal List</h1>

	<table>
		<tr>
			<td>메인이미지</td>
			<td>제목</td>
			<td>성별</td>
			<td>발견한 장소</td>
			<td>발견한 날짜</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./select?num=${dto.num}"> 
					<c:choose>
						<c:when test="${empty dto.fname}">
							<img alt="default" src="../resources/ani/logo01.png" style="background-color: gray;">
						</c:when>
						<c:otherwise>
							<img alt="${dto.oname}" src="../resources/ani/${dto.fname}">
						</c:otherwise>
					</c:choose>
				</a></td>
				<td><a href="./select?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.gender}</td>
				<td>${dto.location}</td>
				<td>${dto.getDate}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pager.curBlock>1}">
		<a href="./list?curPage=${pager.startNum-1}">[이전]</a>
	</c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<a href="./list?curPage=${i}">${i}</a>
	</c:forEach>
	<c:if test="${pager.curBlock<pager.totalBlock}">
		<a href="./list?curPage=${pager.lastNum+1}">[다음]</a>
	</c:if>
	<a href="../">HOME</a>
	<a href="./write">Write</a>
</body>
</html>