<%@ page import="bean.StudentBean" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	List<StudentBean> problems = (List<StudentBean>)request.getAttribute("problems");
%>
<body>
	<table>
	<%
	for(StudentBean bean : problems){
		%>
		<tr>
		<td>
		<%= bean.getProblemId() %>
		</td>
		<td>
		<a href="ProblemDetails?Id=<%= bean.getProblemId() %>"><%= bean.getTitle() %></a>
		
		</td>
		</tr>
		
		<%
	}
	%>
	</table>
</body>
</html>