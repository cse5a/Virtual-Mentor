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
<div style="height:15px;
	width:550px;
	background:#15305b;
	margin-left:70px;
	margin-top:70px;
	border:1px solid;
    padding: 10px;
    border-top-right-radius: 0em;">
<h2 style="font-size:20px;
	color:white;
	margin-left:-10px;
	margin-top:-7px;">Assign Mentor</h2>
</div>
<div style="height:150px;
	width:900px;
	border:1px solid #15305b;
	margin-left:70px;">
<form action="CreateMentor" method="POST">
<table style="margin-left:20px;margin-top:20px;">
<tbody>
<tr>
	<td style="background-color:#a2b3c4;
	display: inline-block;
	padding:5px 5px;
	width:200px;
	height:14px;
	font-size:14px;">
	Faculty Id
	</td>
	<td>
	<input type="text" style="width:230px;height:18px;" name="mentorid"><br>
	</td>
</tr>
<tr>
	<td style="background-color:#a2b3c4;
	display: inline-block;
	padding:5px 5px;
	width:200px;
	height:14px;
	font-size:14px;">
	First Student Id
	</td>
	<td>
	<input type="text" style="width:230px;height:18px;" name="firstid"><br>
	</td>
</tr>
<tr>
	<td style="background-color:#a2b3c4;
	display: inline-block;
	padding:5px 5px;
	width:200px;
	height:14px;
	font-size:14px;">
	Last Student Id
	</td>
	<td>
	<input type="text" style="width:230px;height:18px;" name="lastid"><br>
	</td>
</tr>
</tbody>
</table>
<div style="margin-left:180px;margin-top:10px;"><input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" name="assign"></div>
</form>
</div>
</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>-