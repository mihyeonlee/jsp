<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<JobsVO> jobIdTitleList =(List<JobsVO>) request.getAttribute("jobIdTitle"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>jobID</th>
			<th>title</th>
		</tr>
	<%
		for(JobsVO jobIdTitle : jobIdTitleList){%>
		<tr>
			<td><%=jobIdTitle.getJOB_ID() %></td> 
			<td><%=jobIdTitle.getJOB_TITLE() %></td> 
		</tr>
	<%	}%>
	</table>

</body>
</html>