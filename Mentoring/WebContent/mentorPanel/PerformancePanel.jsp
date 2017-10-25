<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript">
var app = angular.module("myApp",[]);
app.controller('myCtrl',function($scope,$http){
	$scope.chutiya=function()
	{
		//This chutiya panti is invented by satya prakash nandy no professional use this type of code :) Now enjoy 100% working for extra service 500/- cash
		var id=document.getElementById("studentId").value;
		var option=document.getElementById("option1").value;
		var performance=document.getElementById("performance").value;
		$http.get("../PerformancePanel?studentId="+id+"&semester="+option+"&option="+performance+"",{})
	.then(function(response)
	{
		if (performance === "internalMarks"){
			
		}
		else if (performance === "internalPerformance"){
					
		}
		else if (performance === "semesterMarks"){
			
		}
		else if (performance === "attendance"){
			
		}
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
<%
int studentId = Integer.parseInt(request.getParameter("uid"));
%>

<body ng-app="myApp" ng-controller="myCtrl">
<form>
		<input type="text" value=<%=studentId %> id="studentId">
		<select ng-model="option" id="option1">
			<option value="">--Select--</option>
			<option value="FIRST">1st</option>
			<option value="SECOND">2nd</option>
		</select>
		<select ng-model="performance" id="performance">
			<option value="">--Select--</option>
			<option value="attendance">Attendance</option>
			<option value="internalMarks">Internal Marks</option>
			<option value="internalPerformance">Internal Performance</option>
			<option value="semesterMarks">Semester Marks</option>
		</select>
		<button type="button" ng-click="chutiya()">Get Status</button><br>
		<p id="view">{{studentId}}</p>
		<p id="view1"></p>
	</form>
	<table>
		<tr ng-repeat="x in mydata">
			<td>{{x.subjectName}}</td>
			<td>{{x.firstInternalMark}}</td>
			<td>{{x.secondInternalMark}}</td>
			<td>{{x.thirdInternalMark}}</td>
		</tr>
	</table>
</body>
</html>