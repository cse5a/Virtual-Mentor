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
	$scope.showPerformance=function()
	{
		$scope.internalFlag=true;
		$scope.attendanceFlag=true;
		$scope.internalPerformanceFlag = true;
		//This chutiya panti is invented by satya prakash nandy no professional use this type of code :) Now enjoy 100% working for extra service 500/- cash
		var id=document.getElementById("studentId").value;
		var semester=document.getElementById("semester").value;
		var performance=document.getElementById("performance").value;
		$http.get("../PerformancePanel?studentId="+id+"&semester="+semester+"&option="+performance+"",{})
	.then(function(response)
	{
		$scope.mydata=response.data;
		
		if (performance === "internalMarks")
		{
			$scope.internalFlag=false;
		}
		else if (performance === "internalPerformance"){
			$scope.internalPerformanceFlag = false;
			var json = JSON.parse($scope.mydata);
				new Chart(document.getElementById("mixed-chart"), {
				    type: 'bar',
				    data: {
				      labels: [json.jsonSubjectNames],
				      datasets: [{
				          labels: [json.jsonSubjectNames],
				          type: "line",
				          borderColor: "#8e5ea2",
				          data: [json.jsonfirstInternalMark],
				          fill: false
				        }, {
				          labels: [json.jsonSubjectNames],
				          type: "line",
				          borderColor: "#3e95cd",
				          data: [json.jsonsecondInternalMark],
				          fill: false
				        },
				        {
				          labels: [json.jsonSubjectNames],
				          type: "line",
				          borderColor: "black",
				          data: [json.jsonthirdInternalMark],
				          fill: false
				        }, {
				          labels: [json.jsonSubjectNames],
				          type: "bar",
				          backgroundColor: "rgba(0,0,0,0.2)",
				          data: [json.jsonfirstInternalMark],
				        }, {
				          labels: [json.jsonSubjectNames],
				          type: "bar",
				          backgroundColor: "rgba(0,0,0,0.2)",
				          backgroundColorHover: "#3e95cd",
				          data: [json.jsonsecondInternalMark]
				        },
				        {
				          labels: [json.jsonSubjectNames],
				          type: "bar",
				          backgroundColor: "rgba(0,0,0,0.2)",
				          backgroundColorHover: "#3e95cd",
				          data: [json.jsonthirdInternalMark]
				        }
				      ]
				    },
				    options: {
				      title: {
				        display: true,
				        text: 'Population growth (millions): Europe & Africa'
				      },
				      legend: { display: false }
				    }
				});
		}
		else if (performance === "semesterMarks"){
			
		}
		else if (performance === "attendance")
		{
			$scope.attendanceFlag=false;
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
		<select ng-model="semester" id="semester">
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
		<button type="button" ng-click="showPerformance()">Get Status</button><br>
		<p id="view">{{studentId}}</p>
		<p id="view1"></p>
	</form>
	<table>
		<tr ng-repeat="x in mydata" ng-hide="{{internalFlag}}">
			<td>{{x.subjectName}}</td>
			<td>{{x.firstInternalMark}}</td>
			<td>{{x.secondInternalMark}}</td>
			<td>{{x.thirdInternalMark}}</td>
		</tr>
	</table>
	<table>
		<tr ng-repeat="x in mydata" ng-hide="{{attendanceFlag}}">
			<td>{{x.subjectName}}</td>
			<td>{{x.firstMonthTotalClass}}</td>
			<td>{{x.secondMonthTotalClass}}</td>
			<td>{{x.thirdMonthTotalClass}}</td>
			<td>{{x.firstMonthTotalAttended	}}</td>
			<td>{{x.secondMonthTotalAttended	}}</td>
			<td>{{x.thirdMonthTotalAttended	}}</td>
			
		</tr>
	</table>
	
	<canvas id="mixed-chart"  ng-hide="{{internalPerformanceFlag}}">
	</canvas>
	<script type="text/javascript">
		
	</script>
</body>
</html>