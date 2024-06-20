<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 創立JSP物件 -->
 <!--  結合ＥＬ寫法 -->
<jsp:useBean id="member" class="tw.brad.apis.Member"></jsp:useBean>
<jsp:setProperty property="account" value="${param.account }" name="member" />
<jsp:setProperty property="realname" value="${param.realname }" name="member" />   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
			Member1 :
			<jsp:getProperty property="account" name="member" /> :
			<jsp:getProperty property="realname" name="member" /> <hr />
			<!-- 也可以用EL 來簡化寫法 -->
			Member1 : ${member.account } : ${member.realname }
			<!-- 直接印出物件的toString 搭配Member.java -->
			${member }<br />
			<!--產生亂數也可以直接使用  -->
			${Math.random() }
	</body>
</html>