<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 當網頁報錯的時候 將畫面移轉制 brad21-->
<%@ page errorPage="brad21.jsp" %>
   <!-- 接收參數 --> 
    <%
	    String name = request.getParameter("name");
		name.charAt(0);
		if (name == null) name = "World"; 
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1> Brad Big Company</h1>
		<hr>
		<!-- brad20.jsp?name=11 網頁驗證要這樣打 -->
		hello,<%out.print(name); %> <br>
		<!-- 也可以寫成 -->
		hello,<%=name %><br>
		<!-- 也可以從使用後端語言 產生一個隨機數字 -->
		Lottery: <%= (int)(Math.random()*49+1) %><br />
		<!-- 出現一組樂透號碼 -->
		<%
			HashSet<Integer> set = new HashSet<>();
			while (set.size() < 6) set.add((int)(Math.random()*49+1));
			out.print(set);
		%>
	</body>
</html>