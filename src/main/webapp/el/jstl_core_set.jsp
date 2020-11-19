<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>속성 설정전<h3>
	userId : ${userId }<br>
	
	set 태그를 통해 속성을 저장
	<c:set var="userId" value="brown"></c:set>
<!-- 	<>바디에 별도의 내용이 없으면 sign태그로 사용가능<> -->
	<hr>
	<h3>속성 설정후</h3>
	userID : ${userId }<br>
	
	<br>
	객체의 필드 설정도 가능
	<%
			//memberVO가 서블릿을 통해 request객체에 설정되었다고 가정
				//생성하고 나서 값을 설정하는 부분은 없음
				MemberVO memberVO = new MemberVO();
				request.setAttribute("memberVO", memberVO);
		%>
	memberVO : ${memberVO }<br><br>
	
	set태그를 통해 scope객체에 저장된 vo 객체의 필드를 수정(setter)<br>
	
	<c:set target="${memberVO }" property="userid" value="sally"/>
	memberVO : ${memberVO }<br>
	
	<h3>remove태그를 통해 scope 객체에서 속성 제거</h3>
	<c:remove var="memberVO"/>	
	memberVO : ${memberVO }<br>
</body>
</html>