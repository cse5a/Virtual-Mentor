<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
// Angular use begin-----
var app = angular.module("myApp",[]);
app.controller('myCtrl',function($scope,$http){
	$scope.showPerformance=function()
	{
		var id=document.getElementById("studentId").value;
		var semester=document.getElementById("semester").value;
		var performance=document.getElementById("performance").value;
		$http.get("../PerformancePanel?studentId="+id+"&semester="+semester+"&option="+performance+"",{})
	.then(function(response)
	{
		$scope.mydata=response.data;
		(function() {
			document.getElementById("internalMark").style.display="none";
			document.getElementById("attendance").style.display="none";
			document.getElementById("remark").style.display="none";
			document.getElementById("semesterMark").style.display="none";
			document.getElementById("internalPerformance").style.display="none";
		})();
		if (performance === "internalMarks")
			document.getElementById("internalMark").style.display="block";
		else if (performance === "internalPerformance"){
			document.getElementById("internalPerformance").style.display="block";
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
			          label: "",
			          type: "line",
			          borderColor: "#8e5ea2",
			          data: firstInternalMarks,
			          fill: false
			        }, {
			          label: "",
			          type: "line",
			          borderColor: "#3e95cd",
			          data: secondInternalMarks,
			          fill: false
			        },{
			          label: "",
			          type: "line",
			          borderColor: "yellow",
			          data: thirdInternalMarks,
			          fill: false
			        }, {
			          label: "",
			          type: "bar",
			          backgroundColor: "rgba(0,0,0,0.2)",
			          data: firstInternalMarks,
			        }, {
			          label: "",
			          type: "bar",
			          backgroundColor: "rgba(0,0,0,0.2)",
			          backgroundColorHover: "#3e95cd",
			          data: secondInternalMarks,
			        }, {
			          label: "",
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
			        text: 'Internal Performances of 3 Months'
			      },
			      legend: { display: false }
			    }
			});
			//internal performance graph end	
		}
		else if (performance === "semesterMarks")
			document.getElementById("semesterMark").style.display="block";
		else if (performance === "fetchRemarks")
			document.getElementById("remark").style.display="block";
		else if (performance === "attendance")
			document.getElementById("attendance").style.display="block";
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
String name = request.getParameter("name");
%>

<body ng-app="myApp" ng-controller="myCtrl">
<form>
		Regd. No :<input type="text" value=<%=studentId %> id="studentId"  disabled>
		Name :<input type="text" value="<%=name %>"  disabled><br>
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
	<div id="internalMark" style="display:none;">
		<table >
		<tr >
			<th>subjectName</th>
			<th>FirstInternalMark</th>
			<th>SecondInternalMark</th>
			<th>ThirdInternalMark</th>
		</tr>
		<tr ng-repeat="x in mydata">
			<td>{{x.subjectName}}</td>
			<td>{{x.firstInternalMark}}</td>
			<td>{{x.secondInternalMark}}</td>
			<td>{{x.thirdInternalMark}}</td>
		</tr>
	</table>
	</div>
	<div id="attendance" style="display:none;">
		<table>
		<tr ng-repeat="x in mydata">
			<td style="width:400px;">
				<div class="progress">
				    <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:{{x.attendanceInPercentage}}%;background-color:{{x.color}}">
				      {{x.attendanceInPercentage}}%
				    </div>
			    </div>
		    </td>
		   	<td>{{x.subjectName}}</td>
		</tr>
	</table>
	</div>
	<div id="remark" style="display:none;">
		<table>
		<tr ng-repeat="x in mydata">
			<td>{{x.guardian}}</td>
			<td>{{x.mentorRemark}}</td>
			<td>{{x.parentRemark}}</td>
			<td>{{x.date}}</td>
		</tr>
	</table>
	</div>
	<div id="semesterMark" style="display:none;">
		<table>
		<tr ng-repeat="x in mydata">
			<td>{{x.subjectName}}</td>
			<td>{{x.semesterMark}}</td>
		</tr>
	</table>
	</div>
	<div id="internalPerformance" style="display:none;">
		<canvas id="mixed-chart">
		</canvas>
	</div>
</body>
</html>