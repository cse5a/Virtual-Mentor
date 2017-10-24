
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
<a href="Profile.jsp">View Profile</a><br>
<a href="AdminCreation.jsp">Create Admin</a><br>
<a href="InitiationFacultyCreation">Create Faculty</a><br>
<a href="FacultyList">Faculty list</a><br>
<a href="Initiation_StudentCreation">Create Student</a><br>
<a href="StudentList">Student List</a><br>
<a href="CreateMentor.jsp">Assign Mentor</a><br>
<a href="SubjectRegistration.jsp">Subject Registration</a><br>
<a href="FacultyAssignInitiation">Faculty Assign</a><br>
<a href="AssignSemester.jsp">Assign Semester</a><br>
<a href="Logout">Logout</a><br>

</body>
<%
}
	else
		response.sendRedirect("Login.jsp");
	
%>
</html>