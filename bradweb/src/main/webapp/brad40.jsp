<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- prefix="brad" 前置碼 -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="brad" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!-- brad:catch發生例外怎麼處理 -->
	<!-- 設定例外產生的名稱var="自定義意外名稱 -->
	<brad:catch var="error">
	
		<%
			//驗證的時候要打brad40.jsp?n=1 帶參數進入
			String n =request.getParameter("n");
			int num =Integer.parseInt(n);
			out.print(num);
			
		%>
	
	
	</brad:catch>
	hello,ok
	
	<!--捕捉發生錯誤的例外  -->	
	${error }
	
	</body>
</html>