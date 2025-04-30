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


@WebServlet("/LeaveApp")
public class LeaveApp extends HttpServlet {
	int flag = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpDAO user = new EmpDAO();
		String fname = (String)session.getAttribute("loggedUserFName");
				
		String lcode = request.getParameter("lcode");
		String d = request.getParameter("fromDate");
		String des = request.getParameter("des");
		String days = request.getParameter("days");
		String status = "Pending";
		String eid = request.getParameter("eid");
		response.setContentType("text/html");
		
        user.newappl(eid, lcode, des, d, days, status);
        session.setAttribute("leaveapp",user.leaveapp(Integer.parseInt(eid.toString())));
        List<ArrayList<String>> leaveList = user.retrieveleave();
		List<ArrayList<String>> leaveH = user.leaveHistory(Integer.parseInt(eid),fname);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
		request.setAttribute("leaves", leaveList);
		request.setAttribute("leaveH", leaveH);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
