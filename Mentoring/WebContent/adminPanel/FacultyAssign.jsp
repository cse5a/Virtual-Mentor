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
<link rel="stylesheet" href="Source/css/Faculty_Assign.css"> 
</head>
<%
List<UserBean> subjectList = (List<UserBean>)request.getAttribute("subjectList");
List<UserInfo> facultyList = (List<UserInfo>)request.getAttribute("facultyList");
%>
<body>
<div  class="border">
<p class="header">Faculty Assign</p> 
</div>
<div class="border2">
<form action="FacultyAssign" method="post">
<table style="margin-left:20px;margin-top:20px;">
<tbody>
<tr>
<td class="rowstyle">Department </td>
<td><input type="text" style="width:165px;height:18px;" name="department"></td>
<td></td>
<td></td>
<td></td>
<td class="rowstyle">Semester </td>
<td><input type="text" style="width:165px;height:18px;" name="semester"></td>
<td></td>
<td></td>
<td class="rowstyle">Year</td>
<td><input type="text" style="width:165px;height:18px;" name="year"></td>
</tr>
</tbody>
</table>
<table style="margin-left:20px;margin-top:5px;">
<tbody>
<tr>
	<td class="rowstyle">Subject Name</td>
	<td>
		<select style="width:370px;height:24px;" name="subjectCode">
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
	<td></td>
	<td></td>
	<td class="rowstyle">Faculty Name </td>
	<td>
		<select style="width:310px;height:24px;" name="facultyId">
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
</tbody>
</table>
<div style="margin-left:870px;margin-top:5px;"><input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" name="Assign"></div>
</form>
</div>
</body>
</html>