<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/sumCalculation" method="post" id="ff">
	start는 end보다 작게 입력해 주세요.<br>
		start : <input type="text" name="start" value="1"><br>
		end : <input type="text" name="end" value="5"><br>
		<input type="submit" value="전송"> <br>
	</form>



</body>
</html>