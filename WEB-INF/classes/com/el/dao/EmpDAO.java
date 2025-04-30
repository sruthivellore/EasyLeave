package com.el.dao;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.el.dbutility.DBConnection;
import com.el.dto.Employee;

public class EmpDAO {
	public int newEmp(String fname, String lname, String email, String password,String deptc ) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst = 0;
		String r = deptname(deptc);
		if(r.equals("")) {
			return rst;
		}
	
		final String INSERT_QUERY = "insert into Employee (fname, lname, email, password, deptc) values(?, ?, ?, ?,?)";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, fname);	
		    pst.setString(2, lname);
		    pst.setString(3, email);
		    pst.setString(4, password);
		    pst.setString(5, deptc);
		    
		    rst = pst.executeUpdate();
		    con.close();
		    

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rst;
		
	}
	public void newdept(String dcode,String dname ) {
		Connection con = null;
		PreparedStatement pst = null;
		
	
		
		final String INSERT_QUERY = "insert into dept (dcode,dname)values(?, ?)";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, dcode);	
		    pst.setString(2, dname);
		    
		   pst.executeUpdate();
		   con.close();
		    

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void newleave(String lcode,String lname ) {
		Connection con = null;
		PreparedStatement pst = null;
		
	
		
		final String INSERT_QUERY = "insert into leaves (lcode,lname)values(?, ?)";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, lcode);	
		    pst.setString(2, lname);
		    
		   pst.executeUpdate();
		   con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public static String leavename(String lcode) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		String x = "";
	
		
		final String INSERT_QUERY = "select lname from leaves where lcode = ?";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, lcode);	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = rst.getString(1);
		    }
		
		  con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
		
	}
	
	public static String deptname(String dcode) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		String x = "";
	
		
		final String INSERT_QUERY = "select dname from dept where dcode = ?";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, dcode);	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = rst.getString(1);
		    }
		
		  con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
		
	}
	public List<ArrayList<String>> retrieveEmp() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> EmpList = new ArrayList<>();
		String x = "";
			
		final String SELECT_QUERY = "select * from Employee";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	e.add(new Integer(rst.getInt(1)).toString());
				e.add(rst.getString(2));
				e.add(rst.getString(3));
				e.add(rst.getString(4));
				String l = new Integer((leaveacc(rst.getInt(1)))).toString();
				e.add(l);
				x=deptname(rst.getString(6));
				e.add(x);
				EmpList.add(e);

		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return EmpList;	
	}
	public List<ArrayList<String>> retrieveleave() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> lList = new ArrayList<>();
		
		
		
		final String SELECT_QUERY = "select * from leaves";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	
				e.add(rst.getString(1));
				e.add(rst.getString(2));
				
			lList.add(e);
			
		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return lList;	
	}
	public List<ArrayList<String>> retrievedepts() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> lList = new ArrayList<>();
		
		
		
		final String SELECT_QUERY = "select * from dept";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	
				e.add(rst.getString(1));
				e.add(rst.getString(2));
				
			lList.add(e);
			
		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return lList;	
	}
	public int empNo() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		int x = 0;
	
		
		final String INSERT_QUERY = "select count(*) from Employee";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		   	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = new Integer(rst.getInt(1));
		    }
		  con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
		
	}
	public int leavesNo() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		int x = 0;
	
		
		final String INSERT_QUERY = "select count(*) from leaves";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		   	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = new Integer(rst.getInt(1));
		    }
		  con.close();
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
	}
	public int DeptNo() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		int x = 0;
	
		
		final String INSERT_QUERY = "select count(*) from dept";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		   	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = new Integer(rst.getInt(1));
		    }
		  con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
		
	}
	public Employee checkemp(String email, String password) {
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
	    Employee u = null;
		
		final String SELECT_QUERY = "select *from Employee where email = ? and password = ?";  //The '?' are placeholders.
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
		    pst.setString(1, email);
		    pst.setString(2, password);
		    
		    rst = pst.executeQuery();
		    
		    if(rst.next()) {
		   	 u=new Employee();
			 u.setUserId(rst.getInt(1));
			 u.setfname(rst.getString(2));
			 u.setlname(rst.getString(3));
			 u.setEmail(rst.getString(4));
			 u.setPassword(rst.getString(5));
			 u.setdeptcode(rst.getString(6));
		    }
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		  
	return u;
	}
	public void newappl(String eid, String lcode, String des, String d, String days, String status) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst = 0;
	
		final String INSERT_QUERY = "insert into appl (eid, lcode, des, d, days, status) values(?, ?, ?, ?, ?, ?)";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
		    pst.setString(1, eid);	
		    pst.setString(2, lcode);
		    pst.setString(3, des);
		    pst.setString(4, d);
		    pst.setString(5, days);
		    pst.setString(6, status);
		    
		    rst = pst.executeUpdate();
		    
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public List<ArrayList<String>> leaveHistory(int userId, String fname) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> HList = new ArrayList<>();
		
		
		
		final String SELECT_QUERY = "select * from appl where eid = ?";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, userId);
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	e.add((new Integer(rst.getInt(7))).toString());
				e.add(fname);
				e.add(leavename(rst.getString(2)));
				e.add(rst.getString(4));
				e.add(rst.getString(5));
				e.add(rst.getString(3));
				e.add(rst.getString(6));
			
				
			HList.add(e);
			
		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return HList;	
		
	}
	public void changePwd(int eid, String cpwd, String newpwd) {
		Connection con = null;
		PreparedStatement pst = null;
		int rst;  
	    
	    
	    final String UPDATE_QUERY = "update employee set password = ? where eid = ? and password = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);

			pst.setString(1, newpwd);
		    pst.setInt(2, eid);
		    pst.setString(3, cpwd);
		   		    
		    rst = pst.executeUpdate();
		    con.close();
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<ArrayList<String>> leavePending() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> HList = new ArrayList<>();
final String SELECT_QUERY = "select * from appl where status = ? ";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, "pending");
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	e.add((new Integer(rst.getInt(7))).toString());
				e.add(empname(Integer.parseInt(rst.getString(1).toString())));
				e.add(leavename(rst.getString(2)));
				e.add(rst.getString(4));
				e.add(rst.getString(5));
				e.add(rst.getString(3));
				e.add(rst.getString(6));
				
				
			HList.add(e);
			
		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return HList;	
		
	}
	private String empname(int eid) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		String x = "";
	
		
		final String INSERT_QUERY = "select fname from employee where eid = ?";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, eid);	
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = rst.getString(1);
		    }
		
		  con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	public List<ArrayList<String>> leaveHistory() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		List<ArrayList<String>> HList = new ArrayList<>();
final String SELECT_QUERY = "select * from appl where status != ? ";
		
		try {
			con = DBConnection.getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setString(1, "pending");
			    
		    rst = pst.executeQuery();
		    
		    while(rst.next()) {
		    	ArrayList<String> e = new ArrayList<String>();
		    	e.add((new Integer(rst.getInt(7))).toString());
				e.add(empname(Integer.parseInt(rst.getString(1).toString())));
				e.add(leavename(rst.getString(2)));
				e.add(rst.getString(4));
				e.add(rst.getString(5));
				e.add(rst.getString(3));
				e.add(rst.getString(6));
				
				
			HList.add(e);
			
		    }
		    
		}
		
		catch (SQLException E) {
			E.printStackTrace();
		}
		
		return HList;	
		
	}
	public int leaveapp(int userId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		
		int x = 0;
	
		
		final String INSERT_QUERY = "select count(*) from appl where eid = ?";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, userId);
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = new Integer(rst.getInt(1));
		    }
		  con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	public int leaveacc(int userId) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;  
		
		int x = 0;
	
		
		final String INSERT_QUERY = "select sum(days) from appl where eid = ? and status = ?";
		
		try {
			
			con = DBConnection.getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, userId);
			pst.setString(2, "Accepted");
		    
		    
		  rst = pst.executeQuery();
		  if(rst.next()) {
		    	x = new Integer(rst.getInt(1));
		    }
		
		  con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	
	public void lAccept(String aid) {
		Connection con = null;
		PreparedStatement pst = null;
		final String UPDATE_QUERY = "update appl set status = ? where aid = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);
            
			pst.setString(1, "Accepted");
		    pst.setInt(2, Integer.parseInt(aid.replace("[", "")));
		   
		    pst.executeUpdate();
		    con.close();
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public void lRejected(String aid) {
		Connection con = null;
		PreparedStatement pst = null;
		final String UPDATE_QUERY = "update appl set status = ? where aid = ?";
	    
	    try {	
			con = DBConnection.getConnection();
			pst = con.prepareStatement(UPDATE_QUERY);
            
			pst.setString(1, "Rejected");
		    pst.setInt(2, Integer.parseInt(aid.replace("[", "")));
		    
		    pst.executeUpdate();
		    con.close();
	    }
	    catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	}
	


