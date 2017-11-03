<%@ page import="bean.StudentBean" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript">
// Angular use begin-----
var app = angular.module("myApp",[]);
app.controller('myCtrl',function($scope,$http){
	$scope.showProblems = function()
	{
		var semester=document.getElementById("semester").value;
		$http.get("../ViewStudentProblems?semester="+semester+"",{})
	.then(function(response)
	{
		$scope.mydata=response.data;
		
		
	},
	function(error)
	{
		alert("error");
		$scope.myWelcome = response.statusText;
	});
	}
});
</script>
</head>

<body ng-app="myApp" ng-controller="myCtrl">
	<form>
		Semester : 
		<select ng-model="semester" id="semester">
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
		<button type="button" ng-click="showProblems()">Get Problems</button>
	</form>
	<table>
		<tr>
			<td>Student Id</td>
			<td>Problem Title</td>
			
		</tr>
		<tr class='clickable-row' data-href='ProblemDetails' ng-repeat="x in mydata" >
			<td>{{x.studentId}}</td>
			<td ><a href="../ProblemDetails?Id={{x.problemId}}">{{x.title}}</a></td>
		</tr>
		
	</table>
	
	<script type="text/javascript">
	jQuery(document).ready(function($) {
	    $(".clickable-row").click(function() {
	        window.location = $(this).data("href");
	    });
	});
	</script>
</body>
</html>