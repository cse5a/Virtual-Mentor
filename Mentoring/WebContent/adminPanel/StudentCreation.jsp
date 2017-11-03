<%@ page import="bean.UserBean" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Source/css/Student_creation.css">
</head>
<%
List<UserBean> dept_list=(List<UserBean>)request.getAttribute("dept_list");
%>

<body>
<div class="border">
<h1 class="header">Student Creation</h1>
</div>
<div class="border2">
<form action="StudentCreation" method="post">
			<fieldset  style="border: 1px #15305b solid;">
			<legend>Academic Details</legend>
			<table style="margin-left:5px;">
			<tr>
			<td class="rowstyle">Name </td>
			<td><input type="text" style="width:230px;height:18px;" name="Name"></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="rowstyle">Password </td>
			<td><input type="password" style="width:230px;height:18px;" name="Password"></td>
			</tr>
			<tr>
			<td class="rowstyle">Department </td>
			<td>
			<select style="width:235px;height:22px;" name="Department">
			<%
			for(UserBean bean:dept_list)
			{
				%>
			<option value="<%= bean.getDepartment()%>"><%= bean.getDepartment()%></option>
			<%
			}
			%>
			</select></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="rowstyle">Sex </td>
			<td>
			<select style="width:235px;height:22px;" name="Gender">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			</select></td>
			</tr>
			<tr>
			<td class="rowstyle">DOB :</td>
			<td><input type="text" style="width:230px;height:18px;" name="DOB"></td>
			</tr>
			</table>
			</fieldset>
			<fieldset style="border: 1px #15305b solid;">
			<legend>Contact Details</legend>
			<table style="margin-left:5px;">
			<tr>
			<td class="rowstyle">Phone Number </td>
			<td><input type="number" style="width:230px;height:18px;" name="PhoneNumber" ></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="rowstyle">Email  </td>
			<td><input type="email" style="width:230px;height:18px;" name="email" placeholder="@email"></td>
			</tr>
			</table>
			</fieldset>
			<fieldset style="border: 1px #15305b solid;">
			<legend>Parent Details</legend>
			<table style="margin-left:5px;">
			<tr>
			<td class="rowtable2">Father`s Name </td>
			<td><input type="text" style="width:165px;height:18px;" name="Father_Name"></td>
			<td></td>
			<td></td>
			<td class="rowtable2">Father`s Number </td>
			<td><input type="number" style="width:165px;height:18px;" name="Father_PhoneNumber" ></td>
			<td></td>
			<td></td>
			<td class="rowtable2">Father`s Email </td>
			<td><input type="email" style="width:165px;height:18px;" name="Father_email" placeholder="@email"></td>
			</tr>
			<tr>
			<td class="rowtable2">Mother`s Name :</td>
			<td><input type="text" style="width:165px;height:18px;" name="Mother_Name"></td>
			<td></td>
			<td></td>
			<td class="rowtable2">Mother`s Number :</td>
			<td><input type="number" style="width:165px;height:18px;" name="Mother_PhoneNumber" ></td>
			<td></td>
			<td></td>
			<td class="rowtable2">Mother`s Email : </td>
			<td><input type="email" style="width:165px;height:18px;" name="Mother_email" placeholder="@email"></td>
			</tr>
			</table>
			</fieldset>
			<fieldset  style="border: 1px #15305b solid;">
			<legend>Address Details</legend>
			<table style="margin-left:5px;">
			<tr>
			<td class="rowstyle">Village/Street </td>
			<td><input type="text" style="width:230px;height:18px;" name="At"></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="rowstyle">Post-Office </td>
			<td><input type="text" style="width:230px;height:18px;" name="Post"></td>
			</tr>
			<tr>
			<td class="rowstyle">District </td>
			<td><input type="text" style="width:230px;height:18px;" name="Dist"></td>
			<td></td>
			<td></td>
			<td></td>
			<td class="rowstyle">Pin</td>
			<td><input type="text" style="width:230px;height:18px;" name="Pin" /></td>
			</tr>
			<tr>
			<td class="rowstyle">State </td>
			<td><input type="text" style="width:230px;height:18px;" name="State" /></td>
			</tr>
			</table>
			<div style="margin-left:400px;margin-top:10px;">
			<input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" name="save" /></div>
			</fieldset>
		</form>
</div>
</body>
</html>