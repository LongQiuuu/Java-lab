<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 字串與ＥＬ的應用  與讀取範圍的概念-->
   <%
   /* 先宣告JAVA陣列 */
	String[] name1 = {"Brad","Mark","Peter", "Kevin"};
   	//為了EL可以使用需要將陣列放入pageContext.setAttribute肚子裡
	pageContext.setAttribute("key1", name1);
   	//若是我將pageContext.setAttribute註解掉 那他會抓去下方範圍比較小的request.setAttribute
	
   	//再次宣告一個陣列並放入request.setAttribute 肚子裡
	String[] name2 = {"Brad2","Mark2","Peter2", "Kevin2"};
	request.setAttribute("key1", name2);
	
	String[] name3 = {"Brad3","Mark3","Peter3", "Kevin3"};
	session.setAttribute("key1", name3);

	String[] name4 = {"Brad4","Mark4","Peter4", "Kevin4"};
	application.setAttribute("key1", name4);
	
	//建立一個java LinkedList
	LinkedList<String> list = new LinkedList<>();
	pageContext.setAttribute("list", list);
	list.add("AA");list.add("BB");list.add("CC");list.add("DD");
	
	//建立一個Java HashMap 
	HashMap<String,Object> map = new HashMap<>();
	pageContext.setAttribute("person", map);
	map.put("name", "Brad");
	map.put("gender", true);
	map.put("age", 18);
	map.put("weight", 78.4);
	
%> 
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		key1[2] = ${key1[2] }<br />
		<!--requestScope  Scope範圍   -->
		request:key1[2] = ${requestScope.key1[2] }<br />
		session:key1[2] = ${sessionScope.key1[2] }<br />
		application:key1[2] = ${applicationScope.key1[2] }<br />
		
		<!-- 調用list -->
		${list[2] }<br />
		<!-- 調用hasMap -->
		${person.name } : ${person["age"] }
		
	</body>
</html>