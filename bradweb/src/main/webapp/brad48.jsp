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
<!-- 修改資料庫表單欄位內容-->
<!DOCTYPE html>
<html>
	<!-- 語法加入問號 設定問號 照順序的 -->
	<sql:update>
	UPDATE cust SET cname = ? WHERE id = ?
	<sql:param>kkk</sql:param>
	<sql:param>21</sql:param>
	</sql:update>



	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>

	</body>
</html>