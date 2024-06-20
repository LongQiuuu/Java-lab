<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 清除session -->
    <%
    session.invalidate();
    /* 結束之後 導入到其他頁面 */
	//response.sendRedirect("brad50.jsp");
    
    %>
<!-- 摧毀brad50前面儲存的session -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!--  ＪＳ語法 幾秒後跳轉頁面-->
		<meta http-equiv="refresh" content="10; url=brad50.jsp">
		
		<title>Insert title here</title>
	</head>
	<body>
	謝謝光臨
	</body>
</html>