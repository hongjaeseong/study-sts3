<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>MEMO</title>
	
</head>
<body class="m-2 p-2">
		
		<h1>UESR PAGE</h1>
		<hr>
		${authentication}
		<hr>
		${name}
		<hr>
		${principal}
		<hr>
		${isAuthenticated}		
		
</body>
</html>
