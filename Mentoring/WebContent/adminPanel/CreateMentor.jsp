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
<h2>Assign Mentor</h2>
<form action="../CreateMentor" method="POST">
<table>
<tbody>
<tr>
	<td>
	Faulty Id:
	</td>
	<td>
	<input type="text" name="mentorid"><br>
	</td>
</tr>
<tr>
	<td>
	First Student Id:
	</td>
	<td>
	<input type="text" name="firstid"><br>
	</td>
</tr>
<tr>
	<td>
	Last Student Id:
	</td>
	<td>
	<input type="text" name="lastid"><br>
	</td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" name="assign"><br>
	</td>
</tr>

</tbody>

</table>
</form>
</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>-