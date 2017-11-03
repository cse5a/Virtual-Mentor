<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
table{
	border-collapse:collapse;
	width:650px;
}
th,td{
	padding:8px;
	text-allign:left;
	border-bottom:1px solid #ddd;
}
tr:hover{
	background-color:#f5f5f5;
}
</style>
</head>
<%
List<UserInfo> list=(List<UserInfo>)request.getAttribute("list");
%>
<body>
<div style="margin-left:70px;margin-top:50px;border:1px solid;
		padding:6px;background:#415677;width:450px;
		color:white;font-size:18px;border-top-right-radius:10em;">Student Lists</div>
<div style="margin-top:-2px;margin-left:71px;border:1px solid #415677;width:900px;height:550px;">
<table style="margin-left:100px;margin-top:30px;">
	<tr><td style="background-color:#c6c9ce;">
	Student Id
	</td>
	<td style="background-color:#c6c9ce;">
	Student Name
	</td></tr>
<%
for(UserInfo u_info : list){
	%>
	
	<tr class='clickable-row' data-href='StudentProfile?uid=<%=u_info.getId()%>'>
		<td><%=u_info.getId() %></td>
		<td><%=u_info.getName() %></td>
	
	</tr>

	<%
}
%>
</table>
</div>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".clickable-row").click(function(){
			window.location = $(this).data("href");
		});
	});
</script>
</body>
</html>