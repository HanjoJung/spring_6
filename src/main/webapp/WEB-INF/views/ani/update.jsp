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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	var oEditors = [];
	$(function() {

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "contents",
			// SmartEditor2Skin.html 파일이 존재하는 경로
			sSkinURI : "/s6/resources/SE2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				fOnBeforeUnload : function() {

				}
			}
		});

		// 저장버튼 클릭시 form 전송
		$("#save").click(function() {
			oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
			$("#frm").submit();
		});

		$.each($(".kind"), function() {
			if($(this).val() == '${dto.kind}'){
				$(this).attr("checked", "checked")
			};
		})
		
		$.each($(".gender"), function() {
			if($(this).val() == '${dto.gender}'){
				$(this).attr("checked", "checked")
			};
		})
	});
</script>
</head>
<body>
	<h1>Animal Update</h1>

	<form id="frm" action="./update" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num}"> 
		<p>제목 : <input type="text" name="title" value="${dto.title}"></p> 
		<p>종 : 
			강아지<input type="radio" name="kind" value="d" class="kind">
			고양이<input type="radio" name="kind" value="c" class="kind">
		</p>
		<p>이름 : <input type="text" name="name" value="${dto.name}"></p> 
		<p>나이 : <input type="text" name="age" value="${dto.age}"></p> 
		<p>성별 : 
			여자<input type="radio" name="gender" value="f" class="gender">
			남자<input type="radio" name="gender" value="d" class="gender">
		</p> 
		<p>발견날짜 : <input type="date" name="getDate" value="${dto.getDate}"></p> 
		<p>발견장소 : <input type="text" name="location" value="${dto.location}"></p> 
		<p><textarea id="contents" name="contents" rows="20" cols="100">${dto.contents}</textarea></p>
		<p>메인이미지 : <input type="file" name="f1"></p>
<%-- 		<div>
			<img alt="${dto.oname}" src="../resources/ani/${dto.fname}">
		</div> --%>
		<button type="button" id="save">Update</button>
	</form>
</body>
</html>