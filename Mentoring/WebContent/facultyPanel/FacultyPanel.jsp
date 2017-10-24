<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%	
	if(session.getAttribute("USERAUTH") != null)
	{
		boolean isMentor = Boolean.parseBoolean(request.getAttribute("mentor").toString());
%>
<body>
<a href="facultyPanel/Profile.jsp">View Profile</a><br>
<a href="facultyPanel/SubjectDashboard.jsp">Subject List</a><br>
	<%
	if(isMentor == true){
		%>
		<a href="mentorPanel/MentorPanel.jsp">Mentor Panel</a><br>
		<%
	}
	%>

<a href="Logout">Logout</a><br>
</body>
<%
}
	else
	{
		response.sendRedirect("../Login.jsp");
	}
	
%>
</html>