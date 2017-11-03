<%@ page import="bean.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="Source/css/StudentProfile.css">
<title></title>
</head>
<%
	UserInfo student = (UserInfo)request.getAttribute("user_bean");
%>
<body>
<div class="border">
<h1 class="header">Student Profile</h1>
</div>
<div class="border2">
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Personal Details</legend>
		<table style="margin-left:5px;">
		<tr>
		<td class="rowstyle">Student Id </td>
		<td class="row_value"><%= student.getId() %></td>
		<td></td>
		<td></td>
		<td class="rowstyle">Name </td>
		<td class="row_value"><%= student.getName() %></td>
		</tr>
		<tr>
		<td class="rowstyle">Department </td>
		<td class="row_value"><%= student.getDepartment() %></td>
		<td></td>
		<td></td>
		<td class="rowstyle">DOB </td>
		<td class="row_value"><%= student.getDob() %></td>
		</tr>
		<tr>
		<td class="rowstyle">Sex </td>
		<td class="row_value"><%= student.getSex() %></td>
		</tr>
		</table>
		</fieldset>
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Contact Details</legend>
		<table style="margin-left:5px;">
		<tr>
		<td class="rowstyle">Phone Number</td>
		<td class="row_value"><%= student.getNumber() %></td>
		<td></td>
		<td></td>
		<td class="rowstyle">Email :</td>
		<td class="row_value"><%= student.getEmail() %></td>
		</tr>
		</table>
		</fieldset>
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Parent Details</legend>
		<table style="margin-left:5px;">
		<tr>
		<td class="rowtable2">Father`s Name </td>
		<td class="row_value2"><%= student.getF_name() %></td>
		<td></td>
		<td></td>
		<td class="rowtable2">Father`s Number </td>
		<td class="row_value2"><%= student.getF_number() %></td>
		<td></td>
		<td></td>
		<td class="rowtable2">Father`s Email </td>
		<td class="row_value2"><%= student.getF_email() %></td>
		</tr>
		<tr>
		<td class="rowtable2">Mother`s Name </td>
		<td class="row_value2"><%= student.getM_name() %></td>
		<td></td>
		<td></td>
		<td class="rowtable2">Mother`s Number </td>
		<td class="row_value2"><%= student.getM_number() %></td>
		<td></td>
		<td></td>
		<td class="rowtable2">Mother`s Email </td>
		<td class="row_value2"><%= student.getM_email() %></td>
		</tr>
		</table>
		</fieldset>
		<fieldset  style="border: 1px #15305b solid;">
		<legend>Address Details</legend>
		<table style="margin-left:5px;">
		<tr>
		<td class="rowstyle">Village/Street </td>
		<td class="row_value"><%= student.getAt() %></td>
		<td></td>
		<td></td>
		<td class="rowstyle">Post </td>
		<td class="row_value"><%= student.getPost() %></td>
		</tr>
		<tr>
		<td class="rowstyle">District </td>
		<td class="row_value"><%= student.getDistrict() %></td>
		<td></td>
		<td></td>
		<td class="rowstyle">State </td>
		<td class="row_value"><%= student.getState() %></td>
		</tr>
		<tr>
		<td class="rowstyle">Pin </td>
		<td class="row_value"><%= student.getPin() %></td>
		</tr>
		</table>
		</fieldset>
		</div>
</body>
</html>