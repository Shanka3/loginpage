<%@page import="dao.UserDao"%>
<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	UserDao dao = new UserDao();
	UserInfo info = dao.fetch(id);
	%>
	<form action="update" method="post">
		<table cellspacing="13px">
			<tr>
				<th>Id:</th>
				<td><input type="text" value="<%=info.getId()%>" name="name"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" value="<%=info.getName()%>" name="name"></td>
			</tr>
			<tr>
				<th>Phone Number:</th>
				<td><input type="tel" name="phno" value="<%=info.getMobile()%>"
					pattern="[0-9]{10}" required="required"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" name="email"
					value="<%=info.getEmail()%>" required="required"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					value="<%=info.getPassword()%>" required="required"></td>
			</tr>
			<%
			if (info.getGender().equals("male")) {
			%>
			<tr>
				<th>Gender:</th>
				<td><input type="radio" name="gender" value="male"
					checked="checked">Male<input type="radio" name="gender"
					value="female">Female</td>
			</tr>
			<%
			} else {
			%>
			<tr>
				<th>Gender:</th>
				<td><input type="radio" name="gender" value="male">Male<input
					type="radio" name="gender" value="female" checked="checked">Female</td>
			</tr>
			<%
			}
			%>
			<tr>
				<th>D.O.B:</th>
				<td><input type="date" name="dob" value="<%=info.getDate()%>"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><textarea rows="10" cols="30" name="address"><%=info.getAddres()%></textarea></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><select name="country">
						<option>India</option>
						<option>USA</option>
						<option>UAE</option>
						<option>Srilanka</option><%=info.getCountry()%>
				</select></td>
			</tr>
			<tr>
				<th>Skills:</th>
				<%
				String[] skills = info.getSkills();
				for (String s : skills) {
				%>

				<%
				if (s.equals("teamplayer")) {
				%>
				<td><input type="checkbox" name="skills" checked="checked"
					value="teamplayer">Team Player<%
				} else if (s.equals("quickleaarner")) {
				%> <input type="checkbox" name="skills" checked="checked"
					value="quicklearner">Quick Learner <%
 } else if (s.equals("leadership")) {
 %> <input type="checkbox" name="skills" checked="checked""leadership">Leadership
					<%
 }
 }
 %></td>


			</tr>

			<tr>
				<td><button>Update</button></td>
				<td><button type="reset">Cancel</button></td>
			</tr>

		</table>
	</form>
</body>
</html>