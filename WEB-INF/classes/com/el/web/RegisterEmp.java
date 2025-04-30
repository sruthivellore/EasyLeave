package com.el.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.el.dao.EmpDAO;



@WebServlet("/RegisterEmp")
public class RegisterEmp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String deptc = request.getParameter("deptc");
response.setContentType("text/html");
		
		EmpDAO user = new EmpDAO();
		int x = user.newEmp(fname, lname, email, password,deptc);
		
		if(x != 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Success.jsp");
			
		    dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("SignUp.jsp");
		
	    dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
