<%@page import="my.app.entity.Department"%>
<%@page import="my.app.entity.Courses"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Courses - Student Management System</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container py-5">
		<h1 class="mb-4">Courses List</h1>
		<button class="btn btn-warning my-3" data-bs-toggle="modal"
			data-bs-target="#studentModal">Add Course</button>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Course Code</th>
					<th>Credits</th>
					<th>Department</th>
					<!-- New column for department -->
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<%
			  List<Courses> courseList =(List) request.getAttribute("courseList");
		       if(!courseList.isEmpty()){
		    	   for(Courses course: courseList){
		       
			%>
				<!-- Sample Course Data -->
				<tr>
					<td><%= course.getCourse_id() %></td>
					<td><%= course.getCourse_name() %></td>
					<td><%= course.getCourse_code() %></td>
					<td><%=course.getCredits() %></td>
					<td><%= course.getDepartment().getDepartment_name() %></td>
					<!-- Displaying department name -->
					<td><a href="editCourse?u=<%=course.getCourse_id() %>" class="btn btn-warning btn-sm">Edit</a>
						<a href="deleteCourse?u=<%=course.getCourse_id() %>" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
				<%
		    	   }
		       }else{
		    	   %>
		    	   <tr>
		    	    <td colspan="6">No Records.</td>
		    	   </tr>
		    	   <%
		       }
				%>
				
			</tbody>
		</table>
		<!-- Modal -->
		<div class="modal fade" id="studentModal" tabindex="-1"
			aria-labelledby="studentModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h5 class="modal-title" id="studentModalLabel">Enter Course
							Details</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<!-- Modal Body with Form -->
					<div class="modal-body">
						<form id="CourseForm" method="POST" action="save-course">
							<div class="mb-3">
								<label for="firstname" class="form-label">Course Name</label> <input
									type="text" class="form-control" id="coursename"
									name="coursename" required>
							</div>
							<div class="mb-3">
								<label for="lastname" class="form-label">Course Code</label> <input
									type="text" class="form-control" id="coursecode" name="courseCode"
									required>
							</div>
							<div class="mb-3">
								<label for="email" class="form-label">Credits</label> <input
									type="text" class="form-control" id="credits" name="credits"
									required>
							</div>
							<div class="mb-3">
								<label for="gender" class="form-label">Department</label> <select
									class="form-select" id="department" name="department" required>
									<option value="" selected disabled>Select Department</option>
									<%
									 List<Department> dList = (List) request.getAttribute("deptList");
										if(!dList.isEmpty()){
											for(Department d: dList){
												%>
												<option value="<%=d.getDepartment_id() %>"><%=d.getDepartment_name() %></option>
												
												<%
											}
										}
									%>
								</select>
							</div>
							<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" form="CourseForm">Save
							Course</button>
					</div>
						</form>
					</div>

					
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
