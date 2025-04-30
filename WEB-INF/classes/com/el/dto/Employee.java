package com.el.dto;

public class Employee {
	
	private int userId;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String deptcode;
	
	public Employee(){
		
	}
	
	public Employee(int userId, String fname, String lname , String email, String password, String deptcode) {
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.deptcode = deptcode;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstname=" + fname + ", lastname=" + lname + ", userName=" + email
		+ email + ", password=" + password + ", DeptCode=" +deptcode+ "]";
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getfname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}
	
	public String getlname() {
		return lname;
	}
	public void setlname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getdeptcode() {
		return deptcode;
	}
	public void setdeptcode(String deptc) {
		this.deptcode = deptc;
	}

}
