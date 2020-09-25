<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/public.css">
</head>
<body>
	<%-- 자바언어의 철칙 (자바는 굉장히 정적)
		변수를 선언하지 않고 사용할 수 없다.
		객체를 생성하지 않고 사용할 수 없다. 
		
		jsp에서 request, response, session이라는 객체를 사용할 수 있는 것은
		_jspService 메서드에 인자로 선언이 되어있고
		우리가 작성하는 스크립틀릿 코드는 _jspService 메서드안에서 실행이 된다.
		<link href="<%=request.getContextPath() %>/css/public.css"> 절대경로로 작성
		--%>
		
	<%
	
	%>
	<table border="1">
		<tr>
			<td>request.getServerName()</td>
			<td><%=request.getServerName() %></td>
		</tr>
		
		<tr>
			<td>request.getServerPort()</td>
			<td><%=request.getServerPort() %></td>
		</tr>
		
		<tr>
			<td>request.getRequestURI()</td>
			<td><%=request.getRequestURI() %></td>
		</tr>
		
		<tr>
			<td>request.getMethod()</td>
			<td><%=request.getMethod() %></td>
		</tr>
		
		<tr>
			<td>request.getContextPath()</td>
			<td><%=request.getContextPath() %></td>
		</tr>
	</table>
	
	
</body>
</html>