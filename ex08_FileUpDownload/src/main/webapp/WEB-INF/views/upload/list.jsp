<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
</head>
<body>
	<!-- file list를 확인하는 작업 -->
	<h1>FILE LIST</h1>
	BASE DIR : ${root} <br>
	<hr>
	<!-- SUB DIR -->
	<c:forEach var="subdir" items="${root.listFiles()}">	<!-- root경로의 파일의 목록을 subdir 요소로 뽑음 -->
		SUBDIR : ${subdir.getPath()}						<!-- EL를 이용해 subdir의 경로를 출력 -->
		<hr>
		<c:forEach var="file" items="${subdir.listFiles()}">							<!-- subdir경로의 파일의 목록을 file 요소로 뽑음 -->
			<a class="item" href="javascript:void(0)" data-file="${file.getPath()}">	<!-- 비동기처리를 위해 a태그 클릭 시 화면전환 차단  -->
				${file}					<!-- EL를 이용해 file의 경로를 출력 -->
			</a>
			<br>
		</c:forEach>
		<hr>
	</c:forEach>
	
	<hr>
	
	<script>
		const projectPath ="${pageContext.request.contextPath}";
	
		const itemEls = document.querySelectorAll(".item");
		itemEls.forEach(item=>{
			item.addEventListener('click',function(){
				console.log("CLICKED...",item);
				const filepath = item.getAttribute('data-file');
				console.log(filepath);
				location.href = projectPath+"/download?filepath="+encodeURIComponent(filepath);		// javascript 내장객체, 위치를 이동 시킴
			})
		})
	</script>
	

</body>
</html>