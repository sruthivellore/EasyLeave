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
import com.el.dto.Employee;

@WebServlet("/EmployeePage")
public class EmployeePage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("eemail");
		String password = request.getParameter("epassword");
		EmpDAO Empdao = new EmpDAO();
		Employee emp = Empdao.checkemp(email, password);
		
		if(emp != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUserFName", emp.getfname());
			session.setAttribute("loggedUserId", emp.getUserId());
			session.setAttribute("loggedUserLname", emp.getlname());
			session.setAttribute("loggedUserEmail", emp.getEmail());
			session.setAttribute("loggedUserPassword", emp.getPassword());
			session.setAttribute("loggedUserdept", emp.getdeptcode());
			session.setAttribute("deptname",Empdao.deptname(emp.getdeptcode()));
			session.setAttribute("leaveapp",Empdao.leaveapp(emp.getUserId()));
			session.setAttribute("leaveacc",Empdao.leaveacc(emp.getUserId()));
			
			
			List<ArrayList<String>> leaveList = Empdao.retrieveleave();
			List<ArrayList<String>> leaveH = Empdao.leaveHistory(emp.getUserId(),emp.getfname());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee.jsp");
			request.setAttribute("leaves", leaveList);
			request.setAttribute("leaveH", leaveH);
			request.setAttribute("user", emp);
		    dispatcher.forward(request, response);
		}
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("InvalidUser.jsp");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
