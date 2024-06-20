<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <!-- 宣告指向一個定義 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 	<!-- 此處會用到資料庫標籤 -->
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 	
 	
 	<!-- 連接資料庫來源 -->
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	<!-- 目前第幾頁 若沒輸入就顯示第一頁 -->
	<c:set var="page">${empty param.page?1:param.page }</c:set>
	<!-- 一頁有幾筆 -->
	<c:set var="rpp">10</c:set>
	<!-- 初始夜 -->
	<c:set var="start">${(page - 1) * rpp }</c:set>
	<!-- 連線資料庫 撈取資料-->
	<sql:query var="rs">
		SELECT * FROM food LIMIT ${start }, ${rpp }
	</sql:query>	
	
	<!-- 來設定上一頁 下一頁 -->
	<c:set var="prev">${page == 1 ? 1 : page - 1 }</c:set>
	<c:set var="next">${page + 1 }</c:set>
	
<!-- 此章節從資料庫撈取資料並顯示在網頁上並作分頁 -->
<!DOCTYPE html>
<html>
	


	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>美食小吃列表</h1>
		<hr>
		<!-- 新增上一頁 下一頁按鈕 -->
		<hr />
		<a href="?page=${prev }">Prev</a> | <a href="?page=${next }">Next</a>
		<hr />
		
			<table border="1" width="100%">
			<tr>
				<th>#</th>
				<th>id</th>
				<th>名稱</th>
				<th>電話</th>
			</tr>
			
			<c:forEach items="${rs.rows }" var="food" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${food.id }</td>
					<td>${food.name }</td>
					<td>${food.tel }</td>
				</tr>			
			</c:forEach>
			
			
		</table>		
		
	
		
	
		
	</body>
</html>