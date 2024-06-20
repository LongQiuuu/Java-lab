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
	<!-- empty 空白  加上！ 就是不空白 當我有下條件時執行查詢有條件欄位-->
	<!-- 連線資料庫 撈取資料-->
	<c:set var="sql">SELECT * FROM food</c:set>
		<c:if test="${!empty param.key }">
			<c:set var="sql">${sql } WHERE name LIKE '%${param.key }%'</c:set>
		</c:if>
	<sql:query var="rs">${sql }</sql:query>
	
<!-- 此跟brad44功能一樣 只不過將撈取資料庫寫法精簡 -->
<!DOCTYPE html>
<html>
	


	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>美食小吃列表</h1>
		<hr>
		<!-- 列出資料庫總比數 -->
		${rs.rowCount }<br />
		<!-- 列出資料庫總上方欄位 -->
		<c:forEach items="${rs.columnNames }" var="column">
			${column }<br />
		</c:forEach>
		<hr />
		
		<!-- 新增條件搜尋  -->
		<form>
			Keyword: <input name="key" value="${param.key }"/>
			<input type="submit" value="Serach" />
		</form>
		
		<table border="1" width="100%">
			<tr>
				<th>#</th>
				<th>id</th>
				<th>名稱</th>
				<th>電話</th>
			</tr>
			
				<!-- value ＝保留原值 -->
				<!-- items="你要尋訪的什麼"  ｒｓ裡面塞了很多資訊 但我們只需要其中的資料表而已  var="food"-->
			<c:forEach items="${rs.rows }" var="food" varStatus="status">
				<tr>
					<!-- 已經尋訪到了 就將資料放進去 -->
					<td>${status.index }</td>
					<td>${food.id }</td>
					<td>${food.name }</td>
					<td>${food.tel }</td>
				</tr>			
			</c:forEach>
				
		</table>	
		
	
		
	
		
	</body>
</html>