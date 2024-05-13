<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>
	<!-- 파일업로드 폼 태그 작업 -->
	<!-- post방식으로 전달한다는 것 : 파일 업로드를 requestbody에 실어서 전달함 -->
	<form action="${pageContext.request.contextPath}/upload/file" method="post" enctype="multipart/form-data" >
		<input type="file" name="singleFile" />
		<button>UPLOAD</button>
	</form>

</body>
</html>