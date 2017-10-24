<%@ page import="bean.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
	UserInfo student = (UserInfo)request.getAttribute("user_bean");
%>
<body>
		<table>
		<tbody>
		<tr>
		<td>Student Id :</td>
		<td><%= student.getId() %></td>
		</tr>
		<tr>
		<td>Name :</td>
		<td><%= student.getName() %></td>
		</tr>
		<tr>
		<td>Sex :</td>
		<td><%= student.getSex() %></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><%= student.getNumber() %></td>
		</tr>
		<tr>
		<td>Email :</td>
		<td><%= student.getEmail() %></td>
		</tr>
		<tr>
		<td>DOB :</td>
		<td><%= student.getDob() %></td>
		</tr>
		<tr>
		<td>Department :</td>
		<td><%= student.getDepartment() %></td>
		</tr>
		<tr>
		<td>Father`s Name :</td>
		<td><%= student.getF_name() %></td>
		</tr>
		<tr>
		<td>Father`s Number :</td>
		<td><%= student.getF_number() %></td>
		</tr>
		<tr>
		<td>Father`s Email :</td>
		<td><%= student.getF_email() %></td>
		</tr>
		<tr>
		<tr>
		<td>Mother`s Name :</td>
		<td><%= student.getM_name() %></td>
		</tr>
		<tr>
		<td>Mother`s Number :</td>
		<td><%= student.getM_number() %></td>
		</tr>
		<tr>
		<td>Mother`s Email :</td>
		<td><%= student.getM_email() %></td>
		</tr>
		<tr>
		<td>Village/Street :</td>
		<td><%= student.getAt() %></td>
		</tr>
		<tr>
		<td>Post :</td>
		<td><%= student.getPost() %></td>
		</tr>
		<tr>
		<td>District :</td>
		<td><%= student.getDistrict() %></td>
		</tr>
		<tr>
		<td>State :</td>
		<td><%= student.getState() %></td>
		</tr>
		<tr>
		<td>Pin :</td>
		<td><%= student.getPin() %></td>
		</tr>
		
		
		</tbody>
		
		</table>
</body>
</html>