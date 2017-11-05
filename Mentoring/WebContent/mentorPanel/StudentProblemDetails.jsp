<%@page import="bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
StudentBean problemDetail = (StudentBean)request.getAttribute("problemDetail");
%>
<body>
<form action="ProvideSolution" method="post" id="myForm">
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
<td>StudentId :</td>
<td><%= problemDetail.getStudentId() %></td>
</tr>
<tr>
<td>StudentName :</td>
<td><%= problemDetail.getStudentName() %></td>
</tr>
<tr>
<td>Description :</td>
<td><%= problemDetail.getDescription() %></td>
</tr>
<tr>
<td>Semester :</td>
<td><%= problemDetail.getSemester() %></td>
</tr>
<tr>
<td>Date :</td>
<td><%= problemDetail.getDate() %></td>
</tr>

<%
if(problemDetail.getSolution() == null){
	%>
	<tr></tr><tr></tr>
	<tr>
	<td>Solution :</td>
	<td>
	<textarea rows="5" cols="60" form="myForm" name="solution">Give the solution ....</textarea>
	</td>
	</tr>
	<%
}else{
	%>
	<tr>
	<td>Solution :</td>
	<td style="color : green;"><%= problemDetail.getSolution() %></td>
	</tr><tr></tr><tr></tr>
	<tr>
	<td>Update Solution :</td>
	<td>
	<textarea rows="5" cols="60" form="myForm" name="solution">Update the solution ....</textarea>
	</td>
	</tr>
	<%
}

%>


</table>
<input type="hidden" value="<%= problemDetail.getProblemId() %>" name="problemId">
<input type="submit" value="Answer">
</form>
</body>
</html>