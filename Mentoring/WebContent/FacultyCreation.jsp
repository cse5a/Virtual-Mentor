<%@ page import="bean.UserBean" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Creation</title>
</head>
<%
List<UserBean> dept_list=(List<UserBean>)request.getAttribute("dept_list");
%>
<body>

<h1>Faculty Creation</h1>

<form action="FacultyCreation" method="post">
			<table>
			<tr>
			<td>Name :</td>
			<td><input type="text" name="Name"></td>
			</tr>
			<tr>
			<td>Password :</td>
			<td><input type="password" name="Password"></td>
			</tr>
			<tr>
			<td>Sex :</td>
			<td>
			<select name="Gender">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			</select></td>
			</tr>
			<tr>
			<td>Phone Number :</td>
			<td><input type="number" name="PhoneNumber" ></td>
			</tr>
			<tr>
			<td>Email : </td>
			<td><input type="email" name="email" placeholder="@email"></td>
			</tr>
			<tr>
			<td>Department :</td>
			<td>
			<select name="Department">
			<%
			for(UserBean bean:dept_list)
			{
				%>
			<option value="<%= bean.getDepartment()%>"><%= bean.getDepartment()%></option>
			<%
			}
			%>
			</select></td>
			</tr>
			<tr>
			<td>Village/Street :</td>
			<td><input type="text" name="At"></td>
			</tr>
			<tr>
			<td>Post-Office : </td>
			<td><input type="text" name="Post"></td>
			</tr>
			<tr>
			<td>District :</td>
			<td><input type="text" name="Dist"></td>
			</tr>
			<tr>
			<td>Pin :</td>
			<td><input type="text" name="Pin" /></td>
			</tr>
			<tr>
			<td>State :</td>
			<td><input type="text" name="State" /></td>
			</tr>
			
			</table><br>
			<input type="submit" name="save" />
		</form>

</body>
</html>