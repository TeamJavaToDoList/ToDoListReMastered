<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="templates/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/profile.css' />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<c:import url="templates/navbar.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div id="popoverMyPerformance">
				<div class="col-md-5  toppad  pull-left col-md-offset-3 ">
					<A href="edit.html">Edit Profile</A> <A href="edit.html">Logout</A>
					<br>
					<p class=" text-info">${date}</p>
				</div>

				<div
					class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">


					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">${memberProfile.surname},
								${memberProfile.name}</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 col-lg-3 " align="center">
									<c:if test="${empty image }">
										<img alt="User Pic"
											src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
											class="img-circle">
									</c:if>
									<c:if test="${not empty image }">
										<img alt="User Pic" src="data:image/jpeg;base64,${image}"
											class="img-circle" width="115px" height="105px">
									</c:if>
								</div>


								<div class=" col-md-9 col-lg-9 ">
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>Group:</td>
												<c:if test="${not empty memberProfile.group.name}">
													<td>${memberProfile.group.name}</td>
												</c:if>
												<c:if test="${empty memberProfile.group.name}">
													<td>Vacant</td>
												</c:if>
											</tr>
											<tr>
												<td>Start date:</td>
												<td>06/23/2013</td>
											</tr>
											<tr>
												<td>Date of Birth</td>
												<td>01/24/1988</td>
											</tr>

											<tr>
											<tr>
												<td>Gender</td>
												<td>Male</td>
											</tr>
											<tr>
												<td>Home Address</td>
												<td>Metro Manila,Philippines</td>
											</tr>
											<tr>
												<td>Email</td>
												<td><a href="mailto:${memberProfile.email }">${memberProfile.email }</a></td>
											</tr>
											<tr>
												<td>Phone Number</td>
												<td>123-4567-890(Landline)<br>
												<br>555-4567-890(Mobile)
												</td>

											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="panel-footer"></div>

					</div>
				</div>
				<div
					class="pull-right col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-0 col-lg-offset-0 toppad">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">My Performance</h3>
						</div>
						<div class="panel-body">
						<table class="table table-user-information">
						<tbody>
						<tr><td># Of Tasks</td><td>${memberPerformance.noOfTasks}</td></tr>
						<tr><td># Of Completed Tasks</td><td>${memberPerformance.completedTasks}</td></tr>
						<tr><td># Of Incomplete Tasks</td><td>${memberPerformance.tasksToBeCompleted}</td></tr>
						<tr><td>% Of Completed Tasks</td><td>${memberPerformance.percentageCompletedTask}</td></tr>
						<tr><td>Group Performance</td><td>${memberPerformance.groupPerformance}</td></tr>
						
						
						
						</tbody>
						
						</table>
						
						
						
						</div>
						<div class="panel-footer"></div>
						</div>
				</div>
				
				
			</div>
		</div>
	</div>

</body>
<c:import url="templates/javascripts.jsp"></c:import>

<script type="text/javascript"
	src="<c:url value='/resources/javascript/profile.js' />"></script>

</html>