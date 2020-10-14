<%@page import="kr.or.ddit.jobs.model.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	List<JobsVO> jobIdTitleList = (List<JobsVO>) request.getAttribute("jobIdTitle");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/layout/commonLib.jsp"%>
</head>
<body>

	<%@include file="/layout/header.jsp"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
			
				<%@include file="/layout/left.jsp"%>
			
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table border="1">
								<tr>
									<th>jobID</th>
									<th>title</th>
								</tr>
								<%
									for (JobsVO jobIdTitle : jobIdTitleList) {
								%>
								<tr>
									<td><%=jobIdTitle.getJOB_ID()%></td>
									<td><%=jobIdTitle.getJOB_TITLE()%></td>
								</tr>
								<%
									}
								%>
							</table>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>