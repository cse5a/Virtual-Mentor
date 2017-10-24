<%@ page import="java.util.List" %>
<%@ page import="bean.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<UserBean> subNameList = (List<UserBean>)request.getAttribute("subNameList");
int option =Integer.parseInt(request.getParameter("option"));
String link = null;
if(option == 1)
	link = "SubjectMarkingCategory";
else if(option == 2)
	link = "AttendanceTypes";
else if(option == 3)
	link = "DisciplinaryStatusInMonths";
%>
<body>
<table>
<tbody>

<%
for(UserBean bean:subNameList){
	%>
	
	<tr>
	<td><%=bean.getSubjectCode() %></td>
	<td><a href="<%=link %>?SCode=<%=bean.getSubjectCode()%>&SName=<%=bean.getSubjectName()%>&Department=<%=bean.getDepartment() %>&Semester=<%=bean.getSemester() %>&Year=<%=bean.getYear() %> "><%=bean.getSubjectName() %></a></td>
	</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>