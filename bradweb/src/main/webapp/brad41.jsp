<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 插入BradUtils.java -->  
  <%@ page import="tw.brad.apis.*" %>  
 <!-- JSTL應用 -->
 <!-- 需要先宣告 -->
 <!-- prefix="c" 前置碼 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <!-- var="score"設定一個變數成績 -->
<!-- 這邊與BradUtils配合 -->
<c:set var="score">${BradUtils.createScore() }</c:set>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 印出看看 -->
		Score: ${score }<hr />
		<!-- 與if判斷式結合 -->
		<c:if test="${score >= 60 }">Pass</c:if>
		<!-- 這邊不能使用else 所以在下判斷都只能if 符合條件要做的事 -->
		<c:if test="${score < 60 }">Down</c:if>
		<!-- witch寫法  多重選一   -->
		<!-- c:otherwise若上訴都沒達到 則印出 -->
	
		<c:choose>
		<c:when test="${score >= 90 }">A</c:when>
		<c:when test="${score >= 80 }">B</c:when>
		<c:when test="${score >= 70 }">C</c:when>
		<c:when test="${score >= 60 }">D</c:when>
		<c:otherwise>E</c:otherwise>
		</c:choose>
	</body>
</html>