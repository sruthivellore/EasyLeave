<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy Leave</title>
 <link rel="stylesheet" href="https://bootswatch.com/4/cosmo/bootstrap.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="bootstrap.css" rel="stylesheet" media="screen">
  <style>
  body{

    background-color: #DADEF7;

  }
.register{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
    margin-top: 3%;
    padding: 3%;
}
.register-left{
    text-align: center;
    color: #fff;
    margin-top: 4%;
}
.register-left input{
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    width: 60%;
    background: #f8f9fa;
    font-weight: bold;
    color: #383d41;
    margin-top: 30%;
    margin-bottom: 3%;
    cursor: pointer;
}
.register-right{
    background: #f8f9fa;
    border-top-left-radius: 10% 50%;
    border-bottom-left-radius: 10% 50%;
}
.register-left img{
    margin-top: 15%;
    margin-bottom: 5%;
    width: 35%;
    -webkit-animation: mover 2s infinite  alternate;
    animation: mover 1s infinite  alternate;
}
@-webkit-keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
@keyframes mover {
    0% { transform: translateY(0); }
    100% { transform: translateY(-20px); }
}
.register-left p{
    font-weight: lighter;
    padding: 12%;
    margin-top: -9%;
}
.register .register-form{
    padding: 10%;
    margin-top: 10%;
}
.btnRegister{
    float: right;
    margin-top: 10%;
    border: none;
    border-radius: 1.5rem;
    padding: 2%;
    background: #0062cc;
    color: #fff;
    font-weight: 600;
    width: 50%;
    cursor: pointer;
}
.register .nav-tabs{
    margin-top: 3%;
    border: none;
    background: #0062cc;
    border-radius: 1.5rem;
    width: 28%;
    float: right;
}
.register .nav-tabs .nav-link{
    padding: 2%;
    height: 34px;
    font-weight: 600;
    color: #fff;
    border-top-right-radius: 1.5rem;
    border-bottom-right-radius: 1.5rem;
}
.register .nav-tabs .nav-link:hover{
    border: none;
}
.register .nav-tabs .nav-link.active{
    width: 100px;
    color: #0062cc;
    border: 2px solid #0062cc;
    border-top-left-radius: 1.5rem;
    border-bottom-left-radius: 1.5rem;
}
.register-heading{
    text-align: center;
    margin-top: 8%;
    margin-bottom: -15%;
    color: #495057;
}
</style>
</head>
<body>

<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="Envelope.gif" alt=""/>
                        <h3>Welcome to Easy Leave</h3>
                        <p>Manage your leaves online.</p>
                       <br/>
                    </div>
                 <div class="col-md-9 register-right">
                        <ul class="nav-links new-session-tabs nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class ="nav-link active show" id="home-tab" data-toggle="tab" href="#home" aria-controls="home" aria-selected="true">Employee</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" >Manager</a>
                            </li>
                        </ul>
                      
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane active" id="home" >
                            
                                <h3 class="register-heading">Apply as an Employee</h3>
                                <form action="RegisterEmp" method="POST">
                                <div class="row register-form">
                                
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name = "fname" placeholder="First Name *" required="required" title="This field is required." value =""/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name = "lname" placeholder="Last Name *" required="required" title="This field is required." value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name = "password" placeholder="Password *" required="required" title="This field is required." value="" />
                                        </div>
                                                                               
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name = "email" placeholder="Your Email *" required="required" title="This field is required." value="" />
                                        </div>
                                        
                                        <div class="form-group">
                                            <input type="text" class="form-control" name = "deptc" placeholder="Department Code *"required="required" title="This field is required."  value="" />
                                        </div>
                                        
                                        <input type="submit" class="btnRegister" name = "register" value="Register"/>
                                    </div>
                                    </form>
                                    
                                    
                                    <div class="col-md-11">
                                        <p>If already registered <a data-toggle="tab" href="#login" >Login</a></p>
                                    
                                    </div>
                                </div>
                                
                            </div>
                            <div class="tab-pane" id="login" >
                                <h3  class="register-heading">Employee Login</h3>
                                 <form action="EmployeePage" method="POST">
                                <div class="row register-form">
                               
                                
                                    <div class="col-md-10">
                                        
                                        <div class="form-group">
                                            <input type="email" name = "eemail" class="form-control" placeholder="Email *" required="required" title="This field is required." value="" />
                                        </div>
                                        

                                        <div class="form-group">
                                            <input type="password" name = "epassword"  class="form-control" placeholder="Password *" required="required" title="This field is required." value="" />
                                        </div></div>
                                      <div class="col-md-7">  
                                        <input type="submit" class="btnRegister"  value="Login"/><br>
                                        <a data-toggle="tab" href="#home" >Cancel</a>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="profile" >
                                <h3  class="register-heading">Manager Login</h3>
                                <form action="Admin" method="POST">
                                <div class="row register-form">
                                
                                
                                    <div class="col-md-10">
                                        
                                        <div class="form-group">
                                            <input type="email" class="form-control" name = "email" placeholder="Email *" required="required" title="This field is required." value="" />
                                        </div>
                                        

                                        <div class="form-group">
                                            <input type="password" class="form-control" name= "password" placeholder="Password *" required="required" title="This field is required." value="" />
                                        </div></div>
                                      <div class="col-md-7">  
                                        <input type="submit" class="btnRegister"  value="Login"/>
                                        
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            </body>
</html>