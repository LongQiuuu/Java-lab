<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/* 基本型別 */
	int a=10;
	/* session.setAttribute("a", 後面都是物件); */
	session.setAttribute("a", a);
	a++;
	
	/* 陣列 */
	int[] b = {1,2,3,4};
	session.setAttribute("b", b);
	b[2] = 33;
	
	
	/* 引用物件腳踏車 */
	Bike bike = new Bike();
	session.setAttribute("bike", bike);
	bike.upSpeed(); bike.upSpeed();bike.upSpeed();
	bike.upSpeed();bike.upSpeed();bike.upSpeed();
	
	//設定session最大的互動時間 
	/* 10秒後 brad51 就抓不到session值 */
	session.setMaxInactiveInterval(10);
	//結論 用session 最好用物件去帶 基本型別值不會異動
%>    
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<!--基本型別印出  -->
	a1 = <%= a %><br />
	a2 = ${a }<br />
	<hr />
	
	<!-- 陣列 -->
	<!-- JAVA 印出 -->
	b[2] = <%= b[2] %><br />
	<!-- 僅ＥＬ印出 ,他的值也跟著動 -->
	${b[2] }<br />
	<hr />
	<!-- 物件腳踏車 -->
	<%= bike %><br />
	<!-- 僅ＥＬ印出 ,他的值也跟著動 -->
	${bike }<br />
	<a href="brad51.jsp">brad51</a> 
	</body>
</html>