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
	요청 헤더 정보 출력
	<%
		Enumeration<String> headers = request.getHeaderNames();
		// 얼마나 있는지 모르니까 그리고 hasMoreElements는 담께 얼마나잇니
		while(headers.hasMoreElements()){
			String header = headers.nextElement(); %>
			<%=header %> : <%= request.getHeader(header) %><br>
	<%	}
		
		
	%>
	
	
</body>
</html>