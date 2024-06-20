<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
			 String mesg = "";
			//取得參數
	
			String errType = request.getParameter("errType");
				//判斷參數
			if (errType != null){
					if (errType.equals("1")){
						//1 新增失敗
						mesg = "新增失敗";
					}else if (errType.equals("2")){
						//2 帳號重複
						mesg = "帳號重複";
					}
				}
 %>
<!DOCTYPE html>
<!-- 註冊表單 -->
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div><%=mesg %></div>
		<form action="Register" method="post">
			Account: <input name="account"> <br>
			PassWord:<input type="password" name="passwd"><br>
			Realname:<input name="realname"> <br>		
			<input type="submit" value="Register">
		</form>
	</body>
</html>