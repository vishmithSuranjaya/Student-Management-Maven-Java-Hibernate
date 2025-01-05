<%@page import="my.app.entity.Department"%>
<%@page import="java.util.List"%>
<%@page import="my.app.entity.Courses"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% Courses course =(Courses) request.getAttribute("course"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Edit Course - Student Management System</title>
</head>
<body>
	<div class="container py-5">
		<div class="row">
			<h1 class="mb-4">Edit Course</h1>
			<div class="col-md-4">
				<form id="studentEditForm" method="POST"
					action="update-course?u=<%=request.getParameter("u")%>">
					<div class="mb-3">
						<label for="firstname" class="form-label">Course Name</label> <input
							type="text" class="form-control" id="firstname" name="coursename"
							value="<%=course.getCourse_name()%>" required>
					</div>
					<div class="mb-3">
						<label for="lastname" class="form-label">Course Code</label> <input
							type="text" class="form-control" id="lastname" name="courseCode"
							value="<%=course.getCourse_code()%>" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Credits</label> <input
							type="text" class="form-control" id="email" name="credits"
							value="<%=course.getCredits()%>" required>
					</div>
					
					<div class="mb-3">
						<label for="gender" class="form-label">Department</label> <select
							class="form-select" id="dept" name="dept" required>
							<option value="" disabled>Select Department</option>
							<%
							List<Department> dList = (List)request.getAttribute("depts");
							 if(!dList.isEmpty()){
								 for(Department d : dList){
									 String selected = "";
									 if(d.getDepartment_id()==course.getDepartment().getDepartment_id()){
										 selected = "selected";
									 }
								
							%>
							<option value="<%=d.getDepartment_id() %>"><%=d.getDepartment_name() %></option>
							<%
								 }
							 }
							%>
						</select>
					</div>
					
					<div class="mb-3">
						<button type="submit" class="btn btn-primary"
							form="studentEditForm">Update Course</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>