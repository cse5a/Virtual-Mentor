<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Source/css/Assign_semester.css">
</head>
<body>
<div  class="border">
<p class="header">Assign Semester</p> 
</div>
<div class="border2">
<form action="AssignSemester" method="post">
<table style="margin-left:30px;margin-top:20px;">
<tbody>
<tr>
<td class="rowstyle">FirsttStudentId </td> 
<td><input type="text"  style="width:230px;height:18px;" name="FirstStudentId"></td>
<td></td>
<td></td>
<td class="rowstyle">LastStudentId </td>
<td><input type="text" style="width:230px;height:18px;" name="LastStudentId"></td>
</tr>
<tr>
<td class="rowstyle">Department</td>
<td><input type="text" style="width:230px;height:18px;" name="Department"></td>
<td></td>
<td></td>
<td class="rowstyle">Semester </td>
<td> <input type="text" style="width:230px;height:18px;" name="Semester"></td>
</tr>
<tr>
<td class="rowstyle">AcademicYear </td>
<td><input type="text" style="width:230px;height:18px;" name="AcademicYear"></td>
<td></td>
<td></td>
<td></td>
<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" style="width:150px;height:25px;background-color:#a2b3c4;" value="Assign"></td>
</tr>
</tbody>
</table>

</form>
</div>
</body>
</html>