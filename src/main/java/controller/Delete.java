package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/delete")
public class Delete extends HttpServlet{
 protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	 int id = Integer.parseInt(req.getParameter("id"));
	 
	 UserDao dao = new UserDao();
	 UserInfo user = dao.fetch(id);
	 dao.delete(user);
	 
	 req.setAttribute("list", dao.fetchAll());
	 res.getWriter().print("<h1>Deleted Successfully</h1>");
	 req.getRequestDispatcher("Home.jsp").include(req, res);
 }
}
