<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.brad.apis.*" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!-- 純後端 從開放資料抓取資料下來 並寫入到資料庫 -->


<!-- 匯入 -->
<!-- 從ＵＲＬ匯入  -->
<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvMovingRoad.aspx" var="data"></c:import> 

<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
<!--解析JSON 字串  -->
<!--配合BradUtils.java 來搭配 -->
<c:set var="travel" value="${BradUtils.parseTravel(data) }"></c:set>
<!-- 尋訪拿到資料 -->
<c:forEach items="${travel }" var="row">

	<sql:update>
		INSERT INTO travel (name,city,town) VALUES (?,?,?)
		<sql:param>${row["name"] }</sql:param>
		<sql:param>${row.city }</sql:param>
		<sql:param>${row.town }</sql:param>
	</sql:update>
	
</c:forEach>


