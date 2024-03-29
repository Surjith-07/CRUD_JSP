
<%@page import="studentutil.db.DbConnection"%>
<%@page import="studentutil.dao.StudentDAO"%>
<%@page import="studentutil.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>StudentsList</title>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<%-- 	<%
/*response.setHeader("Cache-Control", "no-cache");*/
/*response.setHeader("Pragma", "no-cache");*/
/*  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 */%> --%>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
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
						style="color: white; font-size: 17px;">View Student</a></li>
				</ul>

			</div>
		</div>
	</nav>



	<h4>Student Management</h4>
	<div class="container">
		<table class="table">
			<thead style="color: white;">
				<tr bgcolor="#120671">
					<th scope="col">Id |</th>
					<th scope="col">Name|</th>
					<th scope="col">Department |</th>
					<th scope="col">Branch |</th>
					<th scope="col">Address |</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<div class="red"></div>
			<tbody>
				<%
				List<Student> list = StudentDAO.getAllStudent();
				for (Student ele : list) {
				%>

				<tr bgcolor="#bffef4">
					<td scope="col"><%=ele.getId()%></td>
					<td scope="col"><%=ele.getName()%></td>
					<td scope="col"><%=ele.getDepartment()%></td>
					<td scope="col"><%=ele.getBranch()%></td>
					<td scope="col"><%=ele.getAddress()%></td>
					<td scope="col"><a
						href="DeleteStudent?action=delete&id=<%=ele.getId()%>"><i
							class="fa fa-trash" aria-hidden="true"></i></a> <a
						href="UpdateStudent?action=edit&id=<%=ele.getId()%>"><i
							class="fa fa-edit" aria-hidden="true"></i></a></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
<form action="LogOut" method="get">
	<%
	/*response.setHeader("Cache-Control", "no-cache");*/
	/*response.setHeader("Pragma", "no-cache");*/
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<input type="submit" value="Logout">
</form>
</html>