<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath(); //콘텍스트명 얻어오기.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
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
	});
</script>
</head>
<body>
	<h1>Animal Write</h1>

	<form action="./write" method="post" id="frm" enctype="multipart/form-data">
		<p>제목 : <input type="text" name="title"></p> 
		<p>종 : 
			강아지<input type="radio" name="kind" value="d" checked="checked">
			고양이<input type="radio" name="kind" value="c">
		</p>
		<p>이름 : <input type="text" name="name"></p> 
		<p>나이 : <input type="text" name="age"></p> 
		<p>성별 : 
			여자<input type="radio" name="gender" value="f" checked="checked">
			남자<input type="radio" name="gender" value="d">
		</p> 
		<p>발견날짜 : <input type="date" name="getDate"></p> 
		<p>발견장소 : <input type="text" name="location"></p> 
		<p><textarea id="contents" name="contents" rows="20" cols="100"></textarea></p>
		<p>메인이미지 : <input type="file" name="f1"></p>
		<button type="button" id="save">Write</button>
	</form>
</body>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
</html>