<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	
	<form action="<%=request.getContextPath() %>/el" method="post">
		
		<% String scope = request.getParameter("scope");
			String requestParam = "";
			String sessionParam = "";
			String applicationParam = "";
			
			if(scope == null ||scope.equals("requestValue"))
				requestParam = "checked";
			else if(scope.equals("sessionValue"))
				sessionParam = "checked";
			else if(scope.equals("applicationValue"))
				applicationParam = "checked";
			
		%>
		request	(request)	: <input type="radio" name="scope" value="requestValue" <%=requestParam %> /> <br> 
		session	(request, session)	: <input type="radio" name="scope" value="sessionValue" <%=sessionParam %> /> <br>
		application (request, session, application) : <input type="radio" name="scope" value="applicationValue" <%=applicationParam %> /> 
		<button type="submit">전송</button>
	</form>
	<hr><br>
	attr :  ${attr} (page -> request -> session -> application) <br>
	requestScope : ${requestScope.attr } <br>
	sessionScope : ${sessionScope.attr } <br>
	applicationScope : ${applicationScope.attr } <br>
	<hr><br>
	
	scope parameter : <%=request.getParameter("scope") %> <br>
	scope parameter : ${param.scope } <br>
	<hr><br>
	
	cookie : <%=request.getCookies() %> <br>
	cookie : ${cookie.userid.value } <br>
	<hr><br>
	
	map.key<br>
	rangers.brown : ${rangers.brown } <br>
	rangers.sally : ${rangers.sally } <br><br>
	
	list[인덱스] --> MemberVO, list[인덱스].필드 <br>
	rangersList[0] : ${rangersList[0].userid } <br>
	rangersList[1] : ${rangersList[1] } <br>
	
	
	
</body>
</html>