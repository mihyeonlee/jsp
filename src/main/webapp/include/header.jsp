<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	여러페이지에서 공통적으로 사용할 header.jsp
	<h4>html태그는 한번만 존재해야함 때문에 이런식으로하고 Content의 body안에 include해준다.</h4>
	
	header param: <%= request.getParameter("param") %>