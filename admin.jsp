<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://bootswatch.com/4/cosmo/bootstrap.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link href="bootstrap.css" rel="stylesheet" media="screen">
<style>
table {
    border-collapse: collapse;
    width: 100%;
}
td a + a {
   padding-left: 1em;
} 

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
jumbotron {
    padding: 0.5em 0.6em;
}
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">EasyLeave</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"><i class = "fa fa-home"></i>Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class = "fa fa-envelope"></i>Contact</a>
      </li>
      <li class="nav-item">
       <form action="Logout" method="post">
    		<button type="submit" class="btn btn-primary"><i class="fa fa-sign-out" aria-hidden="true" style="font-size: 1.5em"></i>&nbsp;SIGN OUT</button>
		</form>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
    </ul>
     <form class="form-inline my-2 my-lg-0">
      <!-- <input class="form-control mr-sm-2" placeholder="" type="text">-->
      <i class = "fa fa-bell"></i>
    </form>
  </div>
</nav>
<div class="container-fluid">
<div class="row">
<div class="card border-primary mb-3" style="max-width: 15rem;">
  <div class="card-header"><img src = images/admin.png height="50" width="50" align><br>
  Manager</div>
  <div class="card-body">
    <ul class="nav nav-pills" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <a class="nav-link active" data-toggle="tab" href="#dash"><i class = "fa fa-dashboard"></i>&nbsp;Dashboard</a>
  </li>

  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#dept"><i class = "fa fa-th"></i>&nbsp;Departments</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#emp"><i class = "fa fa-user"></i>&nbsp;Employees</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#leaves"><i class = "fa fa-calendar"></i>&nbsp;Leave Management</a>
     <br><br><br><br><br><br><br><br><br><br><br><br>
  </li>
 
  
  </ul>
</div>
</div>
<div class = "col-md-9">
 <div class="tab-content" id="myTabContent">
   <div class="tab-pane active" id="dash" >
   <div class="jumbotron">
   <div class="row">
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">REGISTERED EMPLOYEES</h6>
        <center><p class = "text-primary lead"> ${em } </p></center>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">LISTED DEPARTMENTS</h6>
       <center> <p class = "text-primary lead"> ${de }</p></center>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title">LEAVE TYPES</h6>
        <center><p class = "text-primary lead"> ${l }</p></center>
      </div>
    </div>
  </div>
</div>
  <hr class="my-6">
  <h4> LATEST LEAVE APPLICATIONS</h4>
  <table>
  <tr class ="table-active">
  <th> L ID</th>
  <th>Employee Name</th>
<th>Leave type</th>
<th>From Date</th>
<th>Days</th>
<th>Description</th>
<th>Status</th>
<th>Action</th>
</tr><tr>
    <c:forEach items="${leavep}" var="p"><tr>
     <c:forEach items="${p}" var="p1">
			
				<td><p><small>${p1 }</small></p></td>
				
			</c:forEach><td>
			<form action = "Accept" method="post">
				<input type = "hidden" name = "application" value = "${p}"/>
			<button type="submit" id="btnSubmit" class="btn btn-success">Accept</button> </form>
			<form action = "Reject" method="post">
				<input type = "hidden" name = "application" value = "${p}"/>
			<button type="submit" id="btnCancel" class="btn btn-primary">Decline</button></form>
			
			</td></tr>
		</c:forEach></tr>
  </table>
</div>
  </div>
   <div class="tab-pane" id="dept" >
   <div class = "jumbotron">
   <div class = "row">
     <div class="card" style="width: 15rem;">
  <div class="card-body">
    <h4 class="card-title text-primary"><strong>Add Department</strong></h4><br><br>
    <form action="AddDept" method="POST">
    <div class="form-group">
      <input type="text" class="form-control" name = "dname" placeholder="Department Name" required="required" title="This field is required." value="" /><br>
     </div><div class="form-group">
      <input type="text" class="form-control" name = "dcode" placeholder="Department Code" required="required" title="This field is required." value="" />
    </div><br>
    <input type="submit" class="btn btn-outline-primary" value="Add"/>
    <a href="#dept" class="card-link"> Cancel</a></form>
  </div>
</div>
 <div class="card" style="width: 30rem;">
  <div class="card-body">
    <h4 class="card-title text-primary"><strong>Department Information</strong></h4>
    <table>
    <tr class ="table-active">
    <th>Department Code</th>
    <th>Department Name</th>
    
    </tr><tr>
    <c:forEach items="${alldept}" var="type"><tr>
     <c:forEach items="${type}" var="e">
			
				<td><p class="lead">${e }</p></td>
				
			</c:forEach></tr>
		</c:forEach></tr>
    
    </table>
     
    
  </div>
</div>
   </div>
   </div>
   </div>
   <div class="tab-pane" id="emp" >
   <div class="card" style="width: 50rem;">
   
  <div class="card-body">
    <h3 class="card-title">EMPLOYEE INFORMATION</h3>
    <table>
    <tr class="table-active">
    <th><p class="text-primary mb-0"> Id</p></th>
    <th><p class="text-primary mb-0">FirstName</p></th>
    <th><p class="text-primary mb-0">LastName</p></th>
    <th><p class="text-primary mb-0">Email</p></th>
    <th><p class="text-primary mb-0">Leaves</p></th>    
    <th><p class="text-primary mb-0">DeptName</p></th>
    </tr>
     <c:forEach items="${emps}" var="emp"><tr>
     <c:forEach items="${emp}" var="e">
			
				<th><p class="lead">${e }</p></th>
				
			</c:forEach></tr>
		</c:forEach>
    </table>
  </div>
</div>
   </div>
   <div class="tab-pane" id="leaves" >
     <ul class="nav nav-tabs">
  <li class="nav-item" role = "presentation">
    <a class="nav-link active show" data-toggle="tab" href="#type">Leave Type</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " data-toggle="tab" href="#appl">Leave Applications</a>
  </li>
</ul>
<div id="myTabContent" class="tab-content">
  <div class="tab-pane active" id="type">
  <div class = "jumbotron">
  <div class = "row">
    <div class="card" style="width: 30rem;">
  <div class="card-body">
    <h4 class="card-title text-primary"><strong>Leave Types</strong></h4>
    <table>
    <tr class ="table-active">
    <th>Leave Code</th>
    <th>Leave Type</th>
    
    </tr><tr>
    <c:forEach items="${leaves}" var="type"><tr>
     <c:forEach items="${type}" var="e">
			
				<td><p class="lead">${e }</p></td>
				
			</c:forEach></tr>
		</c:forEach></tr>
    
    </table>
     
    
  </div>
</div>
<div class="card" style="width: 15rem;">
  <div class="card-body">
    <h4 class="card-title text-primary"><strong>Add Leave Type</strong></h4><br><br>
   <form action="AddLeave" method="POST">
    <div class="form-group">
      <input type="text" class="form-control" name = "lname" placeholder="LEAVE TYPE" required="required" title="This field is required." value="" /><br>
     </div><div class="form-group">
      <input type="text" class="form-control" name = "lcode" placeholder="LEAVE CODE" required="required" title="This field is required." value="" />
    </div><br>
    <input type="submit" class="btn btn-outline-primary" value="Add"/>
   </form>
  </div>
</div>
  </div>
  </div>
  </div>
  <div class="tab-pane " id="appl">
    <div class="card" style="width: 50rem;">
  <div class="card-body">
    <h4 class="card-title">LEAVE APPLICATIONS</h4>
     <table>
     
     <tr class ="table-active">
     <th>L Id</th>
  <th>Employee Name</th>
<th>Leave type</th>
<th>From Date</th>
<th>Days</th>
<th>Description</th>
<th>Status</th>
     </tr>
     <tr>
     <c:forEach items="${leaveH}" var="his"><tr>
     <c:forEach items="${his}" var="hi">
			
				<td><p class ="lead">${hi }</p></td>
				
			</c:forEach></tr></c:forEach>
     </tr>
     </table>
   </div>
   </div>
   </div>
  </div>
</div>
  
   </div>
   </div>
   </div>
   </div>
</body>
</html>