<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- JSTL應用 -->
 <!-- 需要先宣告 -->
 <!-- prefix="c" 前置碼 -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!--var=變數名稱 value=其值  scope=範圍 預設是page -->
	<c:set var="x" value="123"></c:set>
	<c:set var="x" value="345" scope="request"></c:set>
	<!-- 開始使用ＥＬ印出到網頁上 -->
	x=${x }<br>
	x=${requestScope.x }<br>
	
	<!-- 輸出 -->
	<!-- 打c:out會自動帶出value 代表value是標籤必備屬性 -->
	<c:out value="hello word"></c:out> <br>
	<!-- 也可以跟ＥＬ合再一起應用 -->
	<c:out value="${x }"></c:out><br>
	<!-- default="no value"若我沒有帶參數會顯示這個 -->
	<c:out value="${param.i }" default="no value"></c:out><br>
	<!-- 使用tw.brad.apis.Member自己寫的方法連接資料庫 -->
	<jsp:useBean id="member" class=tw.brad.apis.Member></jsp:useBean>
	<!-- 再用JSTL抓資料 -->
	<c:set target="${member }" property="id">4</c:set>
	<c:set target="${member }" property="account">brad</c:set>
	<c:set target="${member }" property="realname">Brad chao</c:set>
	<!--再將他結果印出  -->
	
	<!-- 如果不喜歡這個物件 我可以這樣刪除 -->
	<c:remove var="member"/>
	<!-- 印出看看驗證在不在 -->
	${member }
	
	</body>
</html>