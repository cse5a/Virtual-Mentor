<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
String error = request.getParameter("error");
%>
<body>
	<%
		if(error.equals("1")){
			%>
			<p>Successfull</p>
			<%
		}
		else if(error.equals("0")){
			%>
			<p>Unsuccessfull</p>
			<%
		}
	%>
	<h2>Change Password</h2>
	<form action="ChangePassword">
		Old Password :
		<input type="password" name="oldPassword"><br>
		New Password :
		<input type="password" name="newPassword"><br>
		Confirm Password :
		<input type="password" name="confirmPassword"><br>
		<input type="submit" value="Change Password">
	</form>
</body>
</html>