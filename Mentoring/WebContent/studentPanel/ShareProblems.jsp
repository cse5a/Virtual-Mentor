<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<form action="SubmitProblem" method="post" id="myForm">
<table>
<tr>
<td>
	Title :
</td>
<td>
	<textarea rows="1" cols="40" name="title" >Enter title</textarea>
</td>
</tr>
<tr>
<td>
	Description :
</td>
<td>
	<textarea rows="5" cols="60" name="description" >Enter your text here ...</textarea>
</td>
</tr>
<tr>
<td>
	Semester :
</td>
<td>
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
</td>
</tr>
<tr>

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