<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- client form method : post
				encType : multipart/form-data
	 server - servlet @MultipartConfig
	 		- spring Framework multipartResolver -->
	<form action="<%=request.getContextPath()%>/fileupload/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="text" name="userid" value="브라운">
		<input type="submit" value="전송">
	</form>

</body>
</html>