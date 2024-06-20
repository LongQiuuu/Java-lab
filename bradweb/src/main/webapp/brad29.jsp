<%@page import="tw.brad.apis.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- ＪＡＶＡ版 標籤版區分  配合 Member.java 檔配合  -->   
 <%
 //配合Member.java
 	//java版本
 	//建出Member 產出物件實體  
 	Member member1 = new Member();
	member1.setId(1); member1.setAccount("brad");member1.setRealname("Brad");
 %>
 <!-- 標籤版本 -->
 <!-- 賦予他ＩＤ -->
<jsp:useBean id="member2" class="tw.brad.apis.Member"></jsp:useBean>
<!-- 賦予他屬性  name (哪個物件） -->
<jsp:setProperty property="id" value="2" name="member2" />
<jsp:setProperty property="account" value="amy" name="member2" />
<jsp:setProperty property="realname" value="Amy" name="member2" />


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
			<!-- JAVA 版 顯示在網頁上-->
			Member1 : <%= member1.getId() %> : <%= member1.getAccount() %> : <%= member1.getRealname() %><br />
			<!-- 標籤版  顯示在網頁上-->
			Member2 : <jsp:getProperty property="id" name="member2" /> :
			<jsp:getProperty property="account" name="member2" /> :
			<jsp:getProperty property="realname" name="member2" /> <br />
			
			<!-- 標籤版可以叫出java建構出的  java版 無法叫出標籤的   -->
			Member2 : <%= member2.getId() %> : <%= member2.getAccount() %> : <%= member2.getRealname() %><br />
	</body>
</html>