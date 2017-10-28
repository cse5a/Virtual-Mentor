<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%	
	if(session.getAttribute("USERAUTH") != null){
		
%>
<body>
<form action="SubjectRegistration" method="post">
<table>
<tbody>

	<tr><td>Department Name</td>
		<td>
			<select name="department">
			<option value="CSE">CSE</option>
			</select>
		</td>
	</tr>
	<tr><td>TOPIC 1</td>
		<td><input type="text" name="topic1"></td>
	</tr>
	<tr><td>TOPIC 2</td>
		<td><input type="text" name="topic2"></td>
	</tr>
	<tr><td>TOPIC 3</td>
		<td><input type="text" name="topic3"></td>
	</tr>
	<tr><td>TOPIC 4</td>
		<td><input type="text" name="topic4"></td>
	</tr>
	<tr><td>TOPIC 5</td>
		<td><input type="text" name="topic5"></td>
	</tr>
	<tr><td>TOPIC 6</td>
		<td><input type="text" name="topic6"></td>
	</tr>
	<tr><td>TOPIC 7</td>
		<td><input type="text" name="topic7"></td>
	</tr>
	<tr><td>SEMESTER</td>
		<td><input type="text" name="semester"></td>
	</tr>
	<tr><td>YEAR</td>
		<td><input type="text" name="year"></td>
	</tr>
		
</tbody>

</table>
<input type="submit" value="Register">

</form>

</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>