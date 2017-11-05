<%@page import="bean.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<%
UserInfo studentParentInfo = (UserInfo)request.getAttribute("studentParentInfo");
UserInfo userInfo = (UserInfo)request.getSession().getAttribute("USERINFO");
int mentorId = userInfo.getId();
String error = request.getParameter("error");
String message = "",color="";	
%>
<body style="overflow: hidden;">
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
<div class="row">
	<div class="col-sm-6">
	<h3>Student Details</h3>
	<table>
		<tr>
		<td>Name :</td>
		<td><%= studentParentInfo.getName() %></td>	
		</tr>
		<tr>
			<td>Sex :</td>
			<td><%= studentParentInfo.getSex() %></td>	
		</tr>
		<tr>
			<td>Phone Number :</td>
			<td><%= studentParentInfo.getNumber() %></td>	
		</tr>
		<tr>
			<td>Email :</td>
			<td><%= studentParentInfo.getEmail()%></td>	
		</tr>
		<tr>
			<td>Father's Name :</td>
			<td><%= studentParentInfo.getF_name()%></td>	
		</tr>
		<tr>
			<td>Father's Number :</td>
			<td><%= studentParentInfo.getF_number()%></td>	
		</tr>
		<tr>
			<td>Father's Email :</td>
			<td><%= studentParentInfo.getF_email()%></td>	
		</tr>
		<tr>
			<td>Mother's Name :</td>
			<td><%= studentParentInfo.getM_name()%></td>	
		</tr>
		<tr>
			<td>Mother's Number :</td>
			<td><%= studentParentInfo.getM_number()%></td>	
		</tr>
		<tr>
			<td>Mother's Email :</td>
			<td><%= studentParentInfo.getM_email()%></td>	
		</tr>
		<tr>
			<td>City :</td>
			<td><%= studentParentInfo.getCity()%></td>	
		</tr>
	</table>
	</div>

	<div class="col-sm-6">
			<form action="RecordRemark" method="post">
				<h3>Record Remark</h3>
				<input type="hidden" name="mentorId" value="<%= mentorId%>">
				<input type="hidden" name="studentId" value="<%= studentParentInfo.getId()%>">
				Semester :
				<select name="semester">
					<option value="">--Select--</option>
					<option value="FIRST">1st</option>
					<option value="SECOND">2nd</option>
					<option value="THIRD">3rd</option>
					<option value="FOURTH">4th</option>
					<option value="FIFTH">5th</option>
					<option value="SIXTH">6th</option>
					<option value="SEVENTH">7th</option>
					<option value="EIGHTH">8th</option>
				</select>
				Talked With : 
				<select name="Guardian">
					<option value="">--Select--</option>
					<option value="Father">Father</option>
					<option value="Mother">Mother</option>
					<option value="Local Guardian">Local Guardian</option>
				</select>
				<h5>Parent Remark</h5>
				<textarea cols="60" rows="6" name="parentRemark">Enter parents remark ......
				</textarea>
				<h5>Mentor Remark</h5>
				<textarea cols="60" rows="6" name="mentorRemark">Enter your remark ......
				</textarea>
				<br>
				<input type="submit" value="Record Remark">
			</form>
	</div>
	
</div>
	
</body>
</html>