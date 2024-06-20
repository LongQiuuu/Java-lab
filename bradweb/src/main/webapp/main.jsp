<%@page import="tw.brad.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
    
<!-- 將不合理的人趕走 -->
<%
	if (session.getAttribute("member") == null){
		response.sendRedirect("login.jsp");
		return;
	}	
%> 
<!-- 連線資料庫 -->
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/iii"
	user="root"
	password="root"
/>
<!-- 新增刪除功能 -->
<c:if test="${! empty param.delid }">
	<sql:update>
		DELETE FROM travel WHERE id = ?
		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>

<!-- 搜尋全部表單 -->
<sql:query var="rs">
	SELECT * FROM travel
</sql:query>

<!-- 登入成功轉至頁面 -->   
<!DOCTYPE html>
<html>

	<!-- 用ＪＳ寫跳出視窗 -->
	<script>
			function isDel(delname){
				var isDel = confirm("是否刪除 [" + delname + "] ?");
				return isDel;
			}
	</script>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	Main Page
	<hr />
	Welcome, ${member.realname }
	<hr />
	<a href="logout.jsp">Logout</a>
	<hr />
	<table border="1" width="100%">
		<!--將rs 尋訪出來  -->
		<c:forEach items="${rs.rows }" var="travel">
			<tr>
				<td>${travel.id }</td>
				<td>${travel.name }</td>
				<td>${travel.city }</td>
				<td>${travel.town }</td>
				<td><a href="?delid=${travel.id }" onclick="return isDel('${travel.name }');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	</body>
</html>