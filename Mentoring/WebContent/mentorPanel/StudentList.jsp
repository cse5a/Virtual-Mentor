<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.UserInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<UserInfo> list=(List<UserInfo>)request.getAttribute("studentList");
%>
<body>
<h2>Student List</h2>
<table>
	<tr><th>
	Student Id
	</th>
	<th>
	Student Name
	</th></tr>
<%
for(UserInfo u_info : list){
	%>
	
	<tr>
		<td><a href="#"><%=u_info.getId() %></a></td>
		<td><a href="mentorPanel/PerformancePanel.jsp?uid=<%=u_info.getId()%>&name=<%=u_info.getName() %>"><%=u_info.getName() %></a></td>
	
	</tr>

	<%
}
%>
</table>
</body>
</html>