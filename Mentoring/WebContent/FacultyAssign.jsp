<%@ page import="bean.UserBean" %>
<%@ page import="bean.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<UserBean> subjectList = (List<UserBean>)request.getAttribute("subjectList");
List<UserInfo> facultyList = (List<UserInfo>)request.getAttribute("facultyList");
%>
<body>
<form action="FacultyAssign" method="post">
<table>
<tbody>
<tr>
	<td>Subject Name :</td>
	<td>
		<select name="subjectCode">
			<%
			for(UserBean bean:subjectList)
			{
				%>
			<option value="<%= bean.getSubjectCode()%>"><%= bean.getSubjectName()%></option>
			<%
			}
			%>
			</select>
	</td>
</tr>
<tr>
	<td>Faculty Name :</td>
	<td>
		<select name="facultyId">
			<%
			for(UserInfo bean:facultyList)
			{
				%>
			<option value="<%= bean.getId()%>"><%= bean.getName()%></option>
			<%
			}
			%>
			</select>
	</td>
</tr>
<tr>
	<td>Department :</td>
	<td><input type="text" name="department"></td>
</tr>
<tr>
	<td>Semester :</td>
	<td><input type="text" name="semester"></td>
</tr>
<tr>
	<td>Year :</td>
	<td><input type="text" name="year"></td>
</tr>

</tbody>
</table>
<input type="submit" name="Assign">
</form>
</body>
</html>