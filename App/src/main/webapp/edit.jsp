
<%@page import="studentutil.db.DbConnection"%>
<%@page import="studentutil.db.DbConnection"%>
<%@page import="studentutil.dao.StudentDAO"%>
<%@page import="studentutil.model.Student"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="add.jsp"
						style="color: white; font-size: 17px;">Add Student</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="view.jsp"
						style="color: white; font-size: 17px;">View Students</a></li>
				</ul>

			</div>
		</div>
	</nav>



	<h4>Edit Student</h4>
	<%
	/* String action = request.getParameter("action");
	 */
	String id = request.getParameter("id");
	int p = Integer.parseInt(id.strip());
	Student student = null;
	if (id != null && !id.isEmpty()) {
		student = StudentDAO.getStudentById(p);
	}
	String op = request.getParameter("page");
	%>
	<form method="post" action="UpdateStudent">
		<input type="hidden" name="id" value="<%=p%>">
		<div class="container forn-dlt">
			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Student
						Name :</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" value="<%=student.getName()%>"
						id="inputPassord6" name="name" class="form-control"
						aria-describedby="passwordHelpInline">
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Department
						:</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" value="<%=student.getDepartment()%>"
						id="inputPassword6" name="department" class="form-control"
						aria-describedby="passwordHelpInline">
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Branch :</label>
				</div>
				<div class="col-auto col-lg-8">
					<select class="form-select" aria-label="Default select example"
						name="branch">
						<option selected>Select Branch</option>
						<option value="CSE">CSE</option>
						<option value="IT">IT</option>
						<option value="BSc">BSc</option>
					</select>
				</div>
			</div>


			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Address
						:</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" value="<%=student.getAddress()%>"
						id="inputPassword6" name="address" class="form-control"
						aria-describedby="passwordHelpInline">
				</div>
			</div>


			<div class="row g-3 align-items-centerr">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label"></label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="submit" value="Save" name="">
				</div>
			</div>

		</div>
	</form>
</body>
</html>