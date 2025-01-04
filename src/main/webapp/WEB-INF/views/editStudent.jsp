<%@page import="my.app.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% Student std =(Student) request.getAttribute("student"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Student - Student Edit</title>
</head>
<body>
	<div class="container py-5">
		<div class="row">
		<h1 class="mb-4">Edit Student</h1>
		<h4><%=request.getParameter("u") %></h4>
		<div class="col-md-4">
			<form id="studentEditForm" method="POST" action="update-student?u=<%=request.getParameter("u")%>">
				<div class="mb-3">
					<label for="firstname" class="form-label">First Name</label> <input
						type="text" class="form-control" id="firstname" name="firstname" value="<%=std.getFirst_name() %>"
						required>
				</div>
				<div class="mb-3">
					<label for="lastname" class="form-label">Last Name</label> <input
						type="text" class="form-control" id="lastname" name="lastname" value="<%=std.getLast_name() %>"
						required>
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label> <input
						type="email" class="form-control" id="email" name="email" value="<%=std.getEmail() %>"
						required>
				</div>
				<div class="mb-3">
					<label for="dob" class="form-label">Date of Birth</label> <input
						type="date" class="form-control" id="dob" name="dob" value="<%=std.getDob() %>"
						required>
				</div>
				<div class="mb-3">
					<label for="gender" class="form-label">Gender</label> <select
						class="form-select" id="gender" name="gender" 
						 required>
						<option value="" disabled>Select Gender</option>
						<%
						 if(String.valueOf(std.getGender()).equals("M")){
						%>
						<option value="M" selected>Male</option>
						<% }else{
							
						%>
						<option value="F">Female</option>
						<%
						}
						%>
					</select>
				</div>
				<div class="mb-3">
					<label for="phone" class="form-label">Phone</label> <input
						type="text" class="form-control" id="phone" name="phone" value="<%=std.getPhone() %>"
						required>
				</div>
				<div class="mb-3">
					<label for="address" class="form-label">Address</label>
					<textarea class="form-control" id="address" name="address" rows="3" 
						required><%=std.getAddress() %></textarea>
				</div>
				<div class="mb-3">
					<label for="enrollmentdate" class="form-label">Enrollment
						Date</label> <input type="date" class="form-control" id="enrollmentdate" value="<%=std.getEnrollement_date() %>"
						name="enrollmentdate" required>
				</div>
				<div class="mb-3">
				<button type="submit" class="btn btn-primary" form="studentEditForm">Update Student</button>
			    </div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>