package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Date date = Date.valueOf(req.getParameter("dob"));
		
		UserInfo info = new UserInfo();
		info.setName(req.getParameter("name"));
		info.setEmail(req.getParameter("email"));
		info.setPassword(req.getParameter("password"));
		info.setGender(req.getParameter("gender"));
		info.setAddres(req.getParameter("address"));
		info.setCountry(req.getParameter("country"));
		info.setMobile(Long.parseLong(req.getParameter("phno")));
		info.setDate(date);
		info.setSkills(req.getParameterValues("skills"));
		info.setSetAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());
		 
		
		UserDao dao = new UserDao();
		dao.save(info);
		res.getWriter().print("<h1> Account created succesfully </h1>");
		req.getRequestDispatcher("login.html").include(req, res);

	}

}
