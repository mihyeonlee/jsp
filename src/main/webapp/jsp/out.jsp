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
	<table>
		<tr>
			<th>이름</th>
		</tr>
		
		<tr>
			<th>
		<% List<String> rangers =  (List<String>)request.getAttribute("rangers");  %>
		<% for(String name : rangers){
				out.write(name);
			}
		%>
			</th>
		</tr>
		
	</table>
	
	개발 일반사항 
	servlet => service => jsp작성
	service 코드 작성시 발생한 문제가 servlet, jsp를 만들고 나서야 확인이 됨.
	작성한 코드가 잘돌아가는지 확인하자 
	==> test코드(코드가 잘돌아가는지 확인을 해주는 코드)
		==> 테스트를 자동화 할 수 있다. ==> 코드를 수정하고 다시 반복적으로 테스트하기가 쉬워진다.
	dao => service => servlet
	
	

</body>
</html>