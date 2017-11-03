<%@ page import="bean.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Source/css/StudentProfile.css">
<title>Insert title here</title>
</head>
<%
	UserInfo staff = (UserInfo)request.getAttribute("user_bean");
%>
<body>
<div class="border">
<h1 class="header">Student Profile</h1>
</div>
<div class="border2" style="height:330px;">
<fieldset  style="border: 1px #15305b solid;">
		<legend>Personal Details</legend>
		<table style="margin-left:5px;">
				<tr>
				<td class="rowstyle">Faculty Id </td>
				<td class="row_value"><%= staff.getId() %></td>
				<td></td>
				<td></td>
				<td class="rowstyle">Name </td>
				<td class="row_value"><%= staff.getName() %></td>
				</tr>
				<tr>
				<td class="rowstyle">Department </td>
				<td class="row_value"><%= staff.getDepartment() %></td>
				<td></td>
				<td></td>
				<td class="rowstyle">DOB </td>
				<td class="row_value"><%= staff.getDob() %></td>
				</tr>
				<tr>
				<td class="rowstyle">Sex </td>
				<td class="row_value"><%= staff.getSex() %></td>
				</tr>
		</table>
		</fieldset>
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Contact Details</legend>
		<table style="margin-left:5px;">
				<tr>
				<td class="rowstyle">Phone Number</td>
				<td class="row_value"><%= staff.getNumber() %></td>
				<td></td>
				<td></td>
				<td class="rowstyle">Email </td>
				<td class="row_value"><%= staff.getEmail() %></td>
				</tr>
		</table>
		</fieldset>
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Address Details</legend>
		<table style="margin-left:5px;">
				<tr>
				<td class="rowstyle">Village/Street </td>
				<td class="row_value"><%= staff.getAt() %></td>
				<td></td>
				<td></td>
				<td class="rowstyle">Post </td>
				<td class="row_value"><%= staff.getPost() %></td>
				</tr>
				<tr>
				<td class="rowstyle">District </td>
				<td class="row_value"><%= staff.getDistrict() %></td>
				<td></td>
				<td></td>
				<td class="rowstyle">State </td>
				<td class="row_value"><%= staff.getState() %></td>
				</tr>
				<tr>
				<td class="rowstyle">Pin </td>
				<td class="row_value"><%= staff.getPin() %></td>
				</tr>					
		</table>
		</fieldset>
</body>
</html>