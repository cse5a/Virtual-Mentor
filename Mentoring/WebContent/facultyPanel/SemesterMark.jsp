<%@ page import="java.util.*" %>
<%@ page import="bean.FacultyBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<FacultyBean> StudentList = (List<FacultyBean>)session.getAttribute("StudentList");
int count=0;
%>
<body>
<form action="SemesterMark" method="post">
<table>
<tbody>
<tr>
<td>Total Mark :</td><td><input type="text" name="fullMark"></td>
</tr>
<%
for(FacultyBean bean : StudentList){
	%>
	<tr>
	<td>
	<%=bean.getStudentId() %>
	</td>
	<td><input type="text" name="<%=bean.getStudentId()%>"></td>
	</tr>	
	<%
	count++;
}
%>
<tr>
<td><input type="hidden" name="size" value=<%=count %>></td>
</tr>

</tbody>
</table>
<input type="submit" value="Assign Mark">
</form>
</body>
</html>