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

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

</style>
</head>
<body>
<%
String eid = session.getAttribute("loggedUserId").toString();
String fname = (String)session.getAttribute("loggedUserFName");
String email = (String)session.getAttribute("loggedUserEmail");
String password = (String)session.getAttribute("loggedUserPassword");
String lname = (String)session.getAttribute("loggedUserLname");
String deptc = (String)session.getAttribute("loggedUserdept");
String dept = (String)session.getAttribute("deptname");
String s = " ";
String app = session.getAttribute("leaveapp").toString();
String acc = session.getAttribute("leaveacc").toString();
int limit = 5 - Integer.parseInt(acc);
%>


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
    		<button type="submit" class="btn btn-primary"><i class="fa fa-sign-out" aria-hidden="true" style="font-size: 1.5em"></i>SIGN OUT</button>
		</form>
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
  <%= fname%></div>
  <div class="card-body">
    <ul class="nav nav-pills" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <a class="nav-link active" data-toggle="tab" href="#profile"><i class = "fa fa-user"></i>&nbsp;My profile</a>
  </li>

  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#pwd"><i class = "fa fa-pencil"></i>&nbsp;Change Password</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#LeaveApp"><i class = "fa fa-edit"></i>&nbsp;Apply Leave</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#leavehistory"><i class = "fa fa-list-alt"></i>&nbsp;Leave History</a>
    
  </li>
  
  <br><br><br><br><br><br><br><br><br><br><br><br>
  
  </ul>
</div>
</div>
<div class = "col-md-9">
 <div class="tab-content" id="myTabContent">
   <div class="tab-pane active" id="profile" >
   
   <div class="jumbotron">
   <div class="row">
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title lead">LEAVES APPLIED</h6>
         <center><p class = "text-primary lead"><%= app%> </p></center>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title lead">LEAVES ACCEPTED</h6>
         <center><p class = "text-primary lead"><%= acc%> </p></center>
      </div>
    </div>
  </div>
  <div class="col-sm-4">
    <div class="card">
      <div class="card-body">
        <h6 class="card-title lead">LEAVES LEFT</h6>
         <center><p class = "text-primary lead"> <%= limit%> </p></center>
      </div>
    </div>
  </div>
</div>
<hr class="my-10">
<div class="card style="width: 50rem;">
  <div class="card-body">
    <h4 class="card-title text-primary"><strong>MY PROFILE</strong></h4><br><centre>
    <div class="list-group">
    <h6 class="list-group-item"><strong>
    Employee ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<%= eid%>
  </h6>
    <h6 class="list-group-item"><strong>
    Employee Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<%= fname%><%= s%><%= lname%>
   </h6>
   <h6 class="list-group-item"><strong>
    Employee Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<%= email%>
  </h6>
  <h6 class="list-group-item"><strong>
    Department&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong>&nbsp;&nbsp;&nbsp;&nbsp;<%= dept%>
  </h6>
  
 
</div></centre>
  </div>
</div>
</div>
   
  </div>
   <div class="tab-pane" id="pwd" >
     <div class="card">
  <div class="card-body">
    <h4 class="card-title">Change Password</h4><br><br>
    <form action="Passwordnew" method="POST">
    <div class="form-group">
      <input type="password" class="form-control" name = "cpwd" placeholder="Current Password" required="required" title="This field is required." value="" />
    </div><br>
   <div class="form-group">
      <input type="password" class="form-control" name = "newpwd" placeholder="New Password" required="required" title="This field is required." value="" />
    </div><br>
    <input type="submit" class="btn btn-outline-primary" value="Change"/>
    </form>
  </div>
</div>
   </div>
   <div class="tab-pane" id="LeaveApp" >
   <div class="card" style="width: 50rem;">
   
  <div class="card-body">
    
    <div class="card" style="width: 30rem;">
  <div class="card-body">
    <h4 class="card-title">LEAVE INFO</h4>
    <table>
    <tr class="table-active">
    <th>Leave Code</th>
    <th>Leave Type</th>
    
    </tr><tr>
    <c:forEach items="${leaves}" var="type"><tr>
     <c:forEach items="${type}" var="e">
			
				<td><p class="lead">${e }</p></td>
				
			</c:forEach></tr>
		</c:forEach></tr>
    
    </table>
   </div></div><br><br>
<h3 class="card-title">Leave Application</h3>
     <form action="LeaveApp" method="POST">
    <div class="form-group">
      <input type="hidden" class="form-control" name = "eid"  value="<%= eid%>" />
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" name = "lcode" placeholder="Leave Code" required="required" title="This field is required." value="" />
    </div><br>
    <div class="form-group">
      <input type="date" class="form-control" name = "fromDate" placeholder="Date" required="required" title="This field is required." value="" />
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" name = "days" placeholder="No of Days" required="required" title="This field is required." value="" />
    </div><br>
    <div class="form-group">
      <input type="text" class="form-control" name = "des" placeholder="Description" required="required" title="This field is required." value="" />
    </div><br>
    <input type="submit" class="btn btn-outline-primary" value="Apply"/>
  </form> </div></div></div>
   <div class="tab-pane" id="leavehistory" >
     <div class="card" style=" width: 50rem;">
  <div class="card-body">
    <h4 class="card-title">Leave History</h4><br><br>
    
<table>
<tr class="table-active" >
<th>L Id</th>
<th>Employee Name</th>
<th>Leave type</th>
<th>From Date</th>
<th>Days</th>
<th>Description</th>
<th>Status</th>

</tr><tr>
    <c:forEach items="${leaveH}" var="h"><tr>
     <c:forEach items="${h}" var="h1">
			
				<td><p class="lead">${h1 }</p></td>
				
			</c:forEach></tr>
		</c:forEach></tr>

</table>
    

  </div>
</div>
   </div>
  
  
   </div>
   </div>
   </div>
   </div>
</body>
</html>