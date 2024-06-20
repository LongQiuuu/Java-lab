<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//登出之後轉至頁面
	//清除session
	session.invalidate();
	//跳轉至登入頁面
	response.sendRedirect("login.jsp");
%>

