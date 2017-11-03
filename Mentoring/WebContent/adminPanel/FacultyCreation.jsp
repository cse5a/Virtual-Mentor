<%@ page import="bean.UserBean" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Creation</title>
<link rel="stylesheet" href="Source/css/Faculty_create.css">
</head>
<%
List<UserBean> dept_list=(List<UserBean>)request.getAttribute("dept_list");
%>
<body>
<div style="height:15px;
	width:550px;
	background:#15305b;
	margin-left:50px;
	margin-top:30px;
	border:1px solid;
    padding: 10px;
    border-top-right-radius: 10em">
<p style="font-size:20px;
	color:white;
	margin-top:-6px;">Faculty Creation</p>
</div>
<div style="height:332px;
	width:1000px;
	border:1px solid #15305b;
	margin-left:50px;">
<form action="FacultyCreation" method="post">
			<fieldset style="border: 1px #15305b solid;">
			<legend>Academic Details</legend>
			<table>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Name </td>
			<td><input type="text" style="width:230px;height:18px;" name="Name"></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Password </td>
			<td><input type="password" style="width:230px;height:18px;" name="Password"></td>
			</tr>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Sex </td>
			<td>
			<select style="width:235px;height:24px;" name="Gender">
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			</select></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Department </td>
			<td>
			<select style="width:235px;height:24px;" name="Department">
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
			</table>
			</fieldset><br>
			<fieldset style="border: 1px #15305b solid;">
			<legend>Contact Details</legend>
			<table>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Phone Number </td>
			<td><input type="number" style="width:230px;height:18px;" name="PhoneNumber" ></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Email  </td>
			<td><input type="email" style="width:230px;height:18px;" name="email" placeholder="@email"></td>
			</tr>
			</table>
			</fieldset><br>
			<fieldset style=";border: 1px #15305b solid;">
			<legend>Address Details</legend>
			<table>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;" >Village/Street </td>
			<td><input type="text" style="width:230px;height:18px;" name="At"></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Post-Office  </td>
			<td><input type="text" style="width:230px;height:18px;" name="Post"></td>
			</tr>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">District </td>
			<td><input type="text"  style="width:230px;height:18px;" name="Dist"></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">Pin </td>
			<td><input type="text"  style="width:230px;height:18px;" name="Pin" /></td>
			</tr>
			<tr>
			<td style="background-color:#a2b3c4;display: inline-block;padding:5px 5px;width:170px;
						height:14px;font-size:14px;">State </td>
			<td><input type="text" style="width:230px;height:18px;" name="State" /></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" name="save" /></td>
			</tr>
			</table>
			
			</fieldset>
			
		</form>
</div>
</body>
</html>