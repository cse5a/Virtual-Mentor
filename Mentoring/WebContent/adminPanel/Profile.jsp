<%@page import="bean.UserInfo"%>
<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
<link rel="stylesheet" href="../Source/css/Profile.css">

</head>
<%	
	if(session.getAttribute("USERAUTH") != null){
		UserInfo staff = (UserInfo)session.getAttribute("USERINFO");
%>
	
<body>
	<center>
		<h3><b><u>Admin Information</u></b></h3>
	</center>
	
	<div>
			<fieldset style="width:900px;margin-top:40px;border: 2px #cccccc solid;margin-left:80px;">
			<legend style="color:blue; border: 2px #cccccc solid;">Personal Details</legend>
			<table>
				<tbody>
				<tr>
					<td class="Faculty">Faculty Id</td>
					<td class="Faculty_value"><%= staff.getId() %></td>
					</tr>
					<tr>
					<td class="Faculty">Name </td>
					<td class="Faculty_value"><%= staff.getName() %></td>
					</tr>
					<tr>
					<td class="Faculty">Sex </td>
					<td class="Faculty_value"><%= staff.getSex() %></td>
					</tr>
					</tbody>
					</table>
				</fieldset>
			<fieldset style="width:900px;margin-top:45px;border: 2px #cccccc solid;margin-left:80px;">
				<legend style="color:blue; border: 2px #cccccc solid;">Contact Details </legend>
				<table>
					<tbody>
					<tr>
					<td class="Faculty">Phone Number</td>
					<td class="Faculty_value"><%= staff.getNumber() %></td>
					</tr>
					<tr>
					<td class="Faculty">Email </td>
					<td class="Faculty_value"><%= staff.getEmail() %></td>
					</tr>
					</tbody>
					</table>
					</fieldset>
			<fieldset style="width:900px;margin-top:45px;border: 2px #cccccc solid;margin-left:80px;">
				<legend style="color:blue; border: 2px #cccccc solid;">Address Details </legend>
				<table>
					<tbody>
					<tr>
					<td class="Faculty">City </td>
					<td class="Faculty_value"><%= staff.getCity() %></td>
					</tr>
					<tr>
					<td class="Faculty">State </td>
					<td class="Faculty_value"><%= staff.getState() %></td>
				</tr>
				</tbody>
				</table>
				</fieldset>
	</div>
	<!--div>
	<a href="Logout">Logout</a>
	</div-->
</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>

