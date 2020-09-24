<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // 스크립틀릿: 자바 로직을 작성하는 공간 자동완성으로 해야만 자동 import가 된다. 아님 작성해줘야함.
	Date date = new Date();

%>

	<!-- expression : 화면에 출력을 해준다 
			writer.print() 기능을 한다
	-->
	현재시간 : <%=date %>
</body>
</html>