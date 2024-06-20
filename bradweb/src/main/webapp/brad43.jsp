<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 宣告指向一個定義 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 	<!-- 此處會用到資料庫標籤 -->
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 	
 	
 <!-- 連接資料庫來做新增 刪除 修改動作 -->
<!DOCTYPE html>
<html>
	<!-- 連接資料庫來源 -->
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	<!-- 資料庫 增 刪 修-->
	<sql:update>
	INSERT INTO cust (cname,tel,birthday) VALUES ('aaa','123','1999-01-02')
	</sql:update>
	
	<!-- 也可以加參數進去修改 這樣進網頁的時候 要打參數 brad43?name=hahaha -->
	<sql:update>
	INSERT INTO cust (cname,tel,birthday) VALUES ('${param.cname }','123','1999-01-02')
	</sql:update>
	
	<sql:update>
	UPDATE cust SET cname = 'bbb' WHERE id = 16
	</sql:update>
	
	<sql:update>
	DELETE FROM cust WHERE id = 15
	</sql:update>
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

	</body>
</html>