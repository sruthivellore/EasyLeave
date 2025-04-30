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

import com.el.dao.EmpDAO;

@WebServlet("/Accept")
public class Accept extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String application = (String) request.getParameter("application");
		EmpDAO user = new EmpDAO();
		String arr[] = application.split(",");
	    response.setContentType("text/html");
		
        user.lAccept(arr[0]);
        EmpDAO Empdao = new EmpDAO();
		
		List<ArrayList<String>> EmpList = Empdao.retrieveEmp();
		List<ArrayList<String>> leaveList = Empdao.retrieveleave();
		List<ArrayList<String>> DeptList = Empdao.retrievedepts();
		int employee = Empdao.empNo();
		int leaves = Empdao.leavesNo();
		int dept = Empdao.DeptNo();
		List<ArrayList<String>> leavep = Empdao.leavePending();
		List<ArrayList<String>> leaveHistory = Empdao.leaveHistory();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
		request.setAttribute("leaves", leaveList);
		request.setAttribute("alldept", DeptList);
		request.setAttribute("leavep", leavep);
		request.setAttribute("leaveH", leaveHistory);
		request.setAttribute("emps", EmpList);
		request.setAttribute("l", leaves);
		request.setAttribute("em", employee);
		request.setAttribute("de", dept);
		dispatcher.forward(request, response);
	}

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
