<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <!-- 搭配brad55 觸發時會導入的後端 -->
<%

	String method = request.getMethod();
	/* 新增看接收封包還是get 判斷  成立才回傳參數結果 */
	if (method.equals("POST")){
		/* 也有可能解析不出來 加上 try ....catch  */
		try{
			/* 解析並取得brad55帶來的最大值參數 */
			int max = Integer.parseInt(request.getParameter("max"));
			/* 產生亂數 */
			out.print((int)(Math.random()*max+1));
		}catch(Exception e){
			out.println("ERR");
		}
	}else{
		out.print("What r u doing");
	}

	
%>

