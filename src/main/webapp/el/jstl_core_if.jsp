<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name", "brown");
	
	%>
	el표현식에선 조건을 {}안에 기입해줘야한다. "" 더블쿼테이션 사이에는 공백불가 <br>
	<c:if test="${name =='sally'}">
		sally 
	</c:if>
	
	<c:if test="${name =='brown'}">
		brown
	</c:if>
	<br>
	jstl_core_if.jsp
	
	
</body>
</html>