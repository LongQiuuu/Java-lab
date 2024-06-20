<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- * 封包下所有類別都可以引入 -->
<%@page import="tw.brad.apis.*"%>  
<!DOCTYPE html>
<!-- EL版 加法運算 -->
<!-- 配合 BradUtils -->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<input name="x" type="number" value="${param.x }"/>
			<select name="op">
				<option value="1" ${param.op=="1"?"selected":"" }>加</option>
				<option value="2" ${param.op=="2"?"selected":"" }>減</option>
				<option value="3" ${param.op=="3"?"selected":"" }>乘</option>
				<option value="4" ${param.op=="4"?"selected":"" }>除</option>
			</select>
			<input name="y" type="number" value="${param.y }" />
			<!-- 交給後端去處理 -->
			<!-- 配合 BradUtils -->
			<input type="submit" value="=">
			<span>${BradUtils.calc(param.x, param.y, param.op) }</span>
	</body>
</html>