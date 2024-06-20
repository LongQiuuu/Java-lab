<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 撈取brad37 application的值 -->
<%
	Integer a = (Integer)application.getAttribute("a");
	a++;
	//並將加過的再重新放入 application裡面 
	application.setAttribute("a", a);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- application印出 -->
		a = ${a }
	</body>
</html>