<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<UserInfo> list=(List<UserInfo>)request.getAttribute("list");
%>
<body>
<h2>Faulty List</h2>
<table>
	<tr><th>
	Faculty Id
	</th>
	<th>
	Faculty Name
	</th></tr>
<%
for(UserInfo u_info : list){
	%>
	
	<tr>
		<td><a href="#"><%=u_info.getId() %></a></td>
		<td><a href="../FacultyProfile?uid=<%=u_info.getId() %>"><%=u_info.getName() %></a></td>
	
	</tr>

	<%
}
%>
</table>

</body>
</html>