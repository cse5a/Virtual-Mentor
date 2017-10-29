<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<h1>Admin Creation</h1>
</div>
<form action="AdminCreation" method="post">
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
<td>City :</td>
<td><input type="text" name="At"></td>
</tr>

<tr>
<td>State :</td>
<td><input type="text" name="State" /></td>
</tr>



</table>

<input type="submit" name="Register" />

</form>

</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>