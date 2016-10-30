<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>LIst of all Users</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<body ng-app="myApp" class="ng-cloak">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">        
				<a class="navbar-brand" href="./" style="color: red">Home</a>
				<a class="navbar-brand" href="create" style="color: red">Create User</a>
			</div>
		</div>
    </nav>
	<div class="jumbotron" ng-controller="UserController as ctrl">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>User Name</th>
							<th>Email</th>
							<th>Country</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.users">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.userName"></span></td>
							<td><span ng-bind="u.email"></span></td>
							<td><span ng-bind="u.country"></span></td>
							<td>
							<button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                         	</td>
                         </tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/user_service.js' />"></script>
	<script src="<c:url value='/static/js/controller/user_controller.js' />"></script>
</body>
</html>