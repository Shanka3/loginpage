<%@page import="dto.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Password</th>
			<th>Date</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Skills</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
		List<UserInfo> list = (List<UserInfo>) request.getAttribute("list");
		for (UserInfo info : list) {
		%>
		<tr>
			<th><%=info.getId()%></th>
			<th><%=info.getName()%></th>
			<th><%=info.getMobile()%></th>
			<th><%=info.getEmail()%></th>
			<th><%=info.getPassword()%></th>
			<th><%=info.getDate()%></th>
			<th><%=info.getGender()%></th>
			<th><%=info.getAddres()%></th>
			<th><%=info.getCountry()%></th>
			<th><%=info.getSkills().toString()%></th>
			<th><a href="edit.jsp?id=<%=info.getId()%>"><button>Edit</button></a></th>
			<th><a href="delete?id=<%=info.getId()%>"><button>Delete</button></a></th>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>