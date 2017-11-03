<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Source/css/Subject_registration.css">
</head>
<%	
	if(session.getAttribute("USERAUTH") != null){
		
%>
<body>
<div class="border">
<p class="header"> Subject Registration</p>
</div>
<div class="border2">
<form action="SubjectRegistration" method="post">
<table style="margin-left:20px;margin-top:20px;">
<tbody>
	<tr><td class="rowtable2">Department Name</td>
		<td>
			<select style="width:184px;height:24px;" name="department">
			<option value="CSE">CSE</option>
			</select>
		</td>
		<td></td>
		<td></td>
		<td></td>
	<td class="rowtable2">Semester</td>
		<td><input type="text" style="width:184px;height:18px;" name="semester"></td>
		<td></td>
		<td></td>
		<td></td>
	<td class="rowtable">Year</td>
		<td><input type="text" style="width:184px;height:18px;" name="year"></td>
	</tr>
	</tbody>
	</table>
	<table style="margin-top:5px;margin-left:20px;">
	<tbody>
	<tr><td class="rowstyle">TOPIC 1</td>
		<td><input type="text" style="width:300px;height:24px;" name="topic1"></td>
		<td></td>
		<td></td>
		<td></td>
	<td class="rowstyle">TOPIC 2</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic2"></td>
	</tr>
	<tr><td class="rowstyle">TOPIC 3</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic3"></td>
		<td></td>
		<td></td>
		<td></td>
	<td class="rowstyle">TOPIC 4</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic4"></td>
	</tr>
	<tr><td class="rowstyle">TOPIC 5</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic5"></td>
		<td></td>
		<td></td>
		<td></td>
	<td class="rowstyle">TOPIC 6</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic6"></td>
	</tr>
	<tr><td class="rowstyle">TOPIC 7</td>
		<td><input type="text" style="width:300px;height:20px;" name="topic7"></td>
	</tr>
		
</tbody>

</table>
<div style="margin-left:750px;margin-top:5px;">
<input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" value="Register">
</div>

</form>
</div>

</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>