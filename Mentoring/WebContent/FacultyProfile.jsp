<%@ page import="bean.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	UserInfo staff = (UserInfo)request.getAttribute("user_bean");
%>
<body>

<table>
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
<td>DOB :</td>
<td><%= staff.getDob() %></td>
</tr>
<tr>
<td>Department :</td>
<td><%= staff.getDepartment() %></td>
</tr>
<tr>
<td>Village/Street :</td>
<td><%= staff.getAt() %></td>
</tr>
<tr>
<td>Post :</td>
<td><%= staff.getPost() %></td>
</tr>
<tr>
<td>District :</td>
<td><%= staff.getDistrict() %></td>
</tr>
<tr>
<td>State :</td>
<td><%= staff.getState() %></td>
</tr>
<tr>
<td>Pin :</td>
<td><%= staff.getPin() %></td>
</tr>


</tbody>

</table>
</body>
</html>