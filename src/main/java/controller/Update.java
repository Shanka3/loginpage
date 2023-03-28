package controller;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserInfo;
@WebServlet("/update")
public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		UserInfo info=new UserInfo();
		info.setId(Integer.parseInt(req.getParameter("id")));
		info.setName(req.getParameter("name"));
		info.setEmail(req.getParameter("email"));
		info.setMobile(Long.parseLong(req.getParameter("mobile")));
		info.setGender(req.getParameter("gender"));
		info.setAddres(req.getParameter("address"));
		info.setCountry(req.getParameter("country"));
		info.setDate(Date.valueOf(req.getParameter("date")));
		info.setPassword(req.getParameter("password"));
		
		
	}
	

}
