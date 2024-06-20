<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--配合Brad33.jsp  -->
    <!-- 接收參數 並查看傳送方式正常寫法 -->
    <%
	//out.print(request.getMethod());
	//String[] hobby = request.getParameterValues("hobby");
	%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 傳遞方式用Ｅｌ寫法 -->
		<!-- 沒有這個功能沒關係我再從更上一層pageContext去拿 -->
		Method: ${pageContext.request.method }<br />
		<!--EL呼叫陣列寫法  -->
		1. ${paramValues.hobby[0] }<br />
		2. ${paramValues.hobby[1] }<br />
		3. ${paramValues.hobby[2] }<br />
		4. ${paramValues.hobby[3] }<br />
		5. ${paramValues.hobby[4] }<br />
		6. ${paramValues.hobby[5] }<br />
		
		<!-- 抓取對方的ＩＰ-->
		${pageContext.request.remoteAddr }<br />
		<!-- 顯示瀏覽器的地區 -->
		${pageContext.request.locale }<br />
		<!-- 顯示該地區的語言 -->
		${pageContext.request.locale.displayLanguage } <br>
		<!-- 顯示該地區的語言 java寫法 -->
		<%= request.getLocale().getDisplayLanguage() %>
	</body>
</html>