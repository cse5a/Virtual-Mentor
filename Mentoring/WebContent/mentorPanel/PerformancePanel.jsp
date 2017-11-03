<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript">
// Angular use begin-----
var app = angular.module("myApp",[]);
app.controller('myCtrl',function($scope,$http){
	$scope.showPerformance=function()
	{
		$scope.internalFlag=true;
		$scope.attendanceFlag=true;
		$scope.internalPerformanceFlag = true;
		$scope.remarkFlag = true;
		
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
			var subjetNames = [];
			var firstInternalMarks = [];
			var secondInternalMarks = [];
			var thirdInternalMarks = [];
			angular.forEach($scope.mydata, function(value, key){
				subjetNames.push(value.subjectName);
				firstInternalMarks.push(value.firstInternalMark);
				secondInternalMarks.push(value.secondInternalMark);
				thirdInternalMarks.push(value.thirdInternalMark);
		         });
			
			//internal performance graph start
			new Chart(document.getElementById("mixed-chart"), {
			    type: 'bar',
			    data: {
			      labels: subjetNames,
			      datasets: [{
			          label: "Europe",
			          type: "line",
			          borderColor: "#8e5ea2",
			          data: firstInternalMarks,
			          fill: false
			        }, {
			          label: "Africa",
			          type: "line",
			          borderColor: "#3e95cd",
			          data: secondInternalMarks,
			          fill: false
			        },{
			          label: "Africa",
			          type: "line",
			          borderColor: "black",
			          data: thirdInternalMarks,
			          fill: false
			        }, {
			          label: "Europe",
			          type: "bar",
			          backgroundColor: "rgba(0,0,0,0.2)",
			          data: firstInternalMarks,
			        }, {
			          label: "Africa",
			          type: "bar",
			          backgroundColor: "rgba(0,0,0,0.2)",
			          backgroundColorHover: "#3e95cd",
			          data: secondInternalMarks,
			        }, {
			          label: "Africa",
			          type: "bar",
			          backgroundColor: "rgba(0,0,0,0.2)",
			          backgroundColorHover: "#3e95cd",
			          data: thirdInternalMarks
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
			//internal performance graph end

			
		}
		else if (performance === "semesterMarks"){
			
		}
		else if (performance === "fetchRemarks"){
			$scope.remarkFlag = false;
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
		<input type="hidden" value=<%=studentId %> id="studentId">
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
		Options :
		<select ng-model="performance" id="performance">
			<option value="">--Select--</option>
			<option value="attendance">Attendance</option>
			<option value="internalMarks">Internal Marks</option>
			<option value="internalPerformance">Internal Performance</option>
			<option value="semesterMarks">Semester Marks</option>
			<option value="fetchRemarks">Remarks</option>
		</select>
		<button type="button" ng-click="showPerformance()">Get Status</button>
		<button onclick="location.href='../ContactParents?studentId=<%= studentId%>&error=2'">Contact Parents</button>
		<p id="view">{{studentId}}</p>
		<p id="view1"></p>
	</form>
	<table >
		<tr ng-hide="{{internalFlag}}">
			<td>subjectName</td>
			<td>FirstInternalMark</td>
			<td>SecondInternalMark</td>
			<td>ThirdInternalMark</td>
		</tr>
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
	<table>
		<tr ng-repeat="x in mydata" ng-hide="{{remarkFlag}}">
			<td>{{x.guardian}}</td>
			<td>{{x.mentorRemark}}</td>
			<td>{{x.parentRemark}}</td>
			<td>{{x.date}}</td>
		</tr>
	</table>
	
	<canvas id="mixed-chart" ng-hide="{{internalPerformanceFlag}}">
	</canvas>
	<script type="text/javascript">
	
	</script>
</body>
</html>