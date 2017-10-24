<%@page import="bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
StudentBean problemDetail = (StudentBean)request.getAttribute("problemDetail");
%>
<body>
<table>
<tr>
<td>ProblemId :</td>
<td><%= problemDetail.getProblemId() %></td>
</tr>
<tr>
<td>Title :</td>
<td><%= problemDetail.getTitle() %></td>
</tr>
<tr>
<td>Description :</td>
<td><%= problemDetail.getDescription() %></td>
</tr>
<%
if(problemDetail.getSolution() == null){
	%>
	<tr>
	<td>Solution :</td>
	<td>Un-Answered</td>
	</tr>
	<%
}else{
	%>
	<tr>
	<td>Solution :</td>
	<td><%= problemDetail.getSolution() %></td>
	</tr>
	<%
}

%>

<tr>
<td>Semester :</td>
<td><%= problemDetail.getSemester() %></td>
</tr>
<tr>
<td>Date :</td>
<td><%= problemDetail.getDate() %></td>
</tr>
</table>
</body>
</html>