<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="SubmitProblem" method="post" id="myForm">
<table>
<tr>
<td>
	Title :
</td>
<td>
	<textarea rows="1" cols="40" name="title" form="myForm">Enter title
	</textarea>
</td>
</tr>
<tr>
<td>
	Description :
</td>
<td>
	<textarea rows="5" cols="60" name="description" form="myForm">Enter your text here ...
	</textarea>
</td>
</tr>
<tr>
<td>
	Semester :
</td>
<td>
	<select name="semester">
	<option value="">--Select--</option>
	<option value="1st">1st</option>
	<option value="2nd">2nd</option>
	<option value="3rd">3rd</option>
	<option value="4th">4th</option>
	<option value="5th">5th</option>
	<option value="6th">6th</option>
	<option value="7th">7th</option>
	<option value="8th">8th</option>
	</select>
</td>
</tr>
<tr>
<td>
	Date :
</td>
<td>
	<input type="text" name="date">
</td>
</tr>
<tr>
<td>

</td>
<td>
	<input type="submit" value="share">
</td>
</tr>

</table>
</form>
</body>
</html>