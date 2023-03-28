package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.apache.jasper.tagplugins.jstl.core.Out;
import dao.UserDao;
import dto.UserInfo;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String epn = req.getParameter("epn"), password = req.getParameter("password");
		UserDao dao = new UserDao();
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("login.html");

		List<UserInfo> list = dao.fetchAll();

		try {
			long mobile = Long.parseLong(epn);
			UserInfo user = dao.fetch(mobile);
			if (user == null) {
				out.print("<h1> Invalid Mobile Number </h1>");
				rd.include(req, res);
			} else {
				if (user.getPassword().equals(password)) {
					out.print("<h1> Login Success </h1>");
					req.setAttribute("list", list);
					req.getRequestDispatcher("Home.jsp").include(req, res);
					
					
//					out.print("<table border=1px>");
//					out.print("<tr>");
//					out.print("<th>Id</th>");
//					out.print("<th>Name</th>");
//					out.print("<th>Mobile</th>");
//					out.print("<th>Email</th>");
//					out.print("<th>Password</th>");
//					out.print("<th>Date</th>");
//					out.print("<th>Gender</th>");
//					out.print("<th>Address</th>");
//					out.print("<th>Country</th>");
//					out.print("<th>Skills</th>");
//					out.print("</tr>");
//
//					for (UserInfo user1 : list) {
//						out.print("<tr>");
//						out.print("<th>" + user1.getId() + "</th>");
//						out.print("<th>" + user1.getName() + "</th>");
//						out.print("<th>" + user1.getMobile() + "</th>");
//						out.print("<th>" + user1.getEmail() + "</th>");
//						out.print("<th>" + user1.getPassword() + "</th>");
//						out.print("<th>" + user1.getDate() + "</th>");
//						out.print("<th>" + user1.getGender() + "</th>");
//						out.print("<th>" + user1.getAddres() + "</th>");
//						out.print("<th>" + user1.getCountry() + "</th>");
//						out.print("<th>" + Arrays.toString(user1.getSkills()) + "</th>");
//						out.print("</tr>");
//					}
//					out.print("</table>");
				} else {
					out.print("<h1> Invalid Password </h1>");
					rd.include(req, res);
				}
			}

		} catch (NumberFormatException nfe) {
			String email = epn;
			UserInfo user = dao.fetch(email);
			if (user == null) {
				out.print("<h1> Invalid Email </h1>");
				rd.include(req, res);
			} else {
				if (user.getPassword().equals(password)) {
					out.print("<h1> Login Success </h1>");
					req.setAttribute("list", list);
					req.getRequestDispatcher("Home.jsp").include(req, res);
					
					
//					out.print("<table border=1px>");
//					out.print("<tr>");
//					out.print("<th>Id</th>");
//					out.print("<th>Name</th>");
//					out.print("<th>Mobile</th>");
//					out.print("<th>Email</th>");
//					out.print("<th>Password</th>");
//					out.print("<th>Date</th>");
//					out.print("<th>Gender</th>");
//					out.print("<th>Address</th>");
//					out.print("<th>Country</th>");
//					out.print("<th>Skills</th>");
//					out.print("</tr>");
//
//					for (UserInfo user1 : list) {
//						out.print("<tr>");
//						out.print("<th>" + user1.getId() + "</th>");
//						out.print("<th>" + user1.getName() + "</th>");
//						out.print("<th>" + user1.getMobile() + "</th>");
//						out.print("<th>" + user1.getEmail() + "</th>");
//						out.print("<th>" + user1.getPassword() + "</th>");
//						out.print("<th>" + user1.getDate() + "</th>");
//						out.print("<th>" + user1.getGender() + "</th>");
//						out.print("<th>" + user1.getAddres() + "</th>");
//						out.print("<th>" + user1.getCountry() + "</th>");
//						out.print("<th>" + Arrays.toString(user1.getSkills()) + "</th>");
//						out.print("</tr>");
//					}
//					out.print("</table>");
				} else {
					out.print("<h1> Invalid Password </h1>");
					rd.include(req, res);
				}
			}
		}

	}
}
