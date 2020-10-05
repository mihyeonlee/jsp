<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectView.jsp
	
		<table border="1">
		<tr> 
			<th>이름</th>
		</tr>
		<%--request객체에 저장된 rangers 속성을 이용하여 tr,td 그리고 ranger이름 출력 --%>
		
		<%if(request.getAttribute("rangers")!=null){	%>
		<% List<String> rangers =  (List<String>)request.getAttribute("rangers"); %>
		<%
// 			for(int i=0;i<rangers.size();i++){
			for(String ranger : rangers){
		%>
			<tr> 
<%-- 			<td><%=rangers.get(i) %></td> --%>
				<td><%=ranger%></td>
			</tr>
				
		<%	}%>
	   <%}%>  
			<tr> 
				<td>레인저가 없습니다.</td>
			</tr>
		
		
	</table>
	
</body>
</html>