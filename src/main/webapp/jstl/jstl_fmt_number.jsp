<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// <c:set var="price" value="100000"/>
		request.setAttribute("price", 100000);
	%>
	<%-- setLocale사용할경우 언어_국가 둘다 적어줘야 적용 --%>
	<fmt:setLocale value="de_DE"/>
	price : ${price } <br>
	price-type-number : <fmt:formatNumber value="${price }" type="number" /><br>
	price-type-percent : <fmt:formatNumber value="1" type="percent"/><br> 
	price-type-currency : <fmt:formatNumber value="${price }" type="currency"/><br> 
	price-pattern : <fmt:formatNumber value="${price }" pattern="00,000.00"/><br>
	
	<%-- 문자 => 숫자(파라미터 처리 --%>
	parseNumber : <fmt:parseNumber value="100.000,52"/><br> 
	<%--value를 (var)num안에 저장 --%>
	parseNumber : <fmt:parseNumber value="100.000,52" var="num"/>num = ${num }<br> 
</body>
</html>