<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 宣告指向一個定義 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
 <%
 	//再java建立一個陣列
 	String[] names = {"Brad", "Kevin", "Peter", "Tony", "Vivian", "Mark"};
	pageContext.setAttribute("names", names);
 %>
 
 <!-- 迴圈應用 -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<table border="1" width="100%">
		<tr>
			<th>#</th>
			<th>count</th>
			<th>Name</th>
			<th>isFirst</th>
			<th>isLast</th>
		</tr>
		<!--items="等下是我要尋訪的"  var="指派一個變數名稱" varstatus 狀態＝"status" -->
		<c:forEach items="${names }" var="name" varStatus="status">
			<tr>
				<!-- 陣列第幾個 -->
				<td>${status.index }</td>
				<!-- 累積第幾個 -->
				<td>${status.count }</td>
				<!-- 印出指派變數名稱 -->
				<td>${name }</td>
				<!-- 你是第一個嗎？ 傳回布林值 -->
				<td>${status.first }</td>
				<!--  你是最後一個嗎？ 傳回布林值-->
				<td>${status.last }</td>
			</tr>
		</c:forEach>
		
	</table>
	</body>
</html>