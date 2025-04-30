package com.el.web;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dao.EmpDAO;
import com.el.dto.Employee;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email .equals("admin@gmail.com") && password.equals("sruthi")) {
			
				
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
						
		}else {		
			RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
			dispatcher.forward(request, response);
		}
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
