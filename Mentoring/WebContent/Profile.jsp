<%@page import="bean.UserInfo"%>
<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
</head>
<%	
	if(session.getAttribute("USERAUTH") != null){
		UserInfo staff = (UserInfo)session.getAttribute("USERINFO");
%>
	
<body>
	
	<div>
		<table>
			<thead>
				
			</thead>
			<tbody>
				<tr>
					<td>Faculty Id :</td>
					<td><%= staff.getId() %></td>
					</tr>
					<tr>
					<td>Name :</td>
					<td><%= staff.getName() %></td>
					</tr>
					<tr>
					<td>Sex :</td>
					<td><%= staff.getSex() %></td>
					</tr>
					<tr>
					<td>Phone Number:</td>
					<td><%= staff.getNumber() %></td>
					</tr>
					<tr>
					<td>Email :</td>
					<td><%= staff.getEmail() %></td>
					</tr>
					<tr>
					<tr>
					<td>City :</td>
					<td><%= staff.getCity() %></td>
					</tr>
					<tr>
					<td>State :</td>
					<td><%= staff.getState() %></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div>
	<a href="Logout">Logout</a>
	</div>
</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>

