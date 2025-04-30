package com.el.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.el.dao.EmpDAO;

@WebServlet("/Passwordnew")
public class Passwordnew extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpDAO user = new EmpDAO();
		String fname = (String)session.getAttribute("loggedUserFName");
		String eid = (session.getAttribute("loggedUserId")).toString();	
		String cpwd = request.getParameter("cpwd");
		String newpwd = request.getParameter("newpwd");
		
		response.setContentType("text/html");
		
        user.changePwd(Integer.parseInt(eid), cpwd, newpwd);
        List<ArrayList<String>> leaveList = user.retrieveleave();
		List<ArrayList<String>> leaveH = user.leaveHistory(Integer.parseInt(eid),fname);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
		request.setAttribute("leaves", leaveList);
		request.setAttribute("leaveH", leaveH);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
