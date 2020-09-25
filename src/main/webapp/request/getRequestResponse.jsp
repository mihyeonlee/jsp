<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<%String select = request.getParameter("select"); %>
	<h1><%=select %></h1>
	<hr>
	userId 파라미터는 green,lime 두개를 보내지만 getParameter를 호출하면 
	첫번째 파라미터 값을 반환<br>
	request.getParameter("userId") : <%=request.getParameter("userId") %><br><br>
	
	<hr>
	String[]을 반환<br>
	request.getParameter("userId") : 
	<%
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){
			
	%>
	
	<%= userId %>
	<%}%><br><br>
	<hr>
	
	parameterMap : Map<String, String[]> <br>
	request.getParameterMap() : <%=request.getParameterMap() %>
	<br><br>
	
	<hr>
	요청에 존재하는 파라미터이름 출력하기 userId, pass
	<%
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
	%>
	request.getParameterNames() : 
			<%=name %>
	<% 	}%>
	
	

	
	
</body>
</html>