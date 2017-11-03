<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Admin</title>
<link rel="stylesheet" href="../Source/css/Admin_create.css">
</head>

<%	
	if(session.getAttribute("USERAUTH") != null){
		
%>
<body>
<div class="border">
<p class="header">Admin Creation</p>
</div>
<div class="border2">
<form action="AdminCreation" method="post">
<table style="margin-left:20px;margin-top:20px;">
<tr>
<td class="rowstyle">Name </td>
<td><input type="text" style="width:230px;height:18px;" name="Name"></td>
<td></td>
<td></td>
<td class="rowstyle">Password </td>
<td><input type="password" style="width:230px;height:18px;" name="Password"></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<td class="rowstyle">Sex </td>
<td >
<select style="width:235px;height:24px;" name="Gender">
<option value="Male">Male</option>
<option value="Female">Female</option>
</select></td>
<td></td>
<td></td>
<td class="rowstyle">Phone Number </td>
<td><input style="width:230px;height:20px;" type="number" name="PhoneNumber" ></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<td class="rowstyle">Email  </td>
<td><input type="email" style="width:230px;height:20px;" type="number" name="email" placeholder="@email"></td>
<td></td>
<td></td>
<td class="rowstyle">City </td>
<td><input type="text" style="width:230px;height:20px;" type="number" name="At"></td>
</tr>
<tr></tr>
<tr></tr>
<tr>
<td class="rowstyle">State </td>
<td><input type="text" style="width:230px;height:20px;" name="State" /></td>
<td></td>
<td></td>
<td></td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" value="Register" /></td>
</tr>

</table>

</form>
</div>

</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
%>
</html>