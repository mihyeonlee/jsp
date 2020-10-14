<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/mulCalculation" method="post">
		param1<input type="text" name="param1" value="2"><br>
		param2<input type="text" name="param2" value="5"><br>
		<input type="submit" value="전송"><br>
	</form>

</body>
</html>