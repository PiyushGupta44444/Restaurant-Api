<%@page language="java" contentType="text/html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!Doctype html>
<html>
<head>
<title> AdminLogin </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"  >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body style="background : black;">
<h1 class="text-center" style="color:white;">Welcome Boss</h1>
<div class="container">
<div class="row mt-5">
<div class="col-md-6 offset-md-3">



<form action="/admin/index" method="post" class="bg-white p-4 " >

  <div class="form-group">
  <h2 class="text-center">Log In</h2>
  
    <label  for="exampleInputEmail1">Username or Email address</label>
    <input type="email" class="form-control" name="userName" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <p style="color:red; font-size:15px"> <form:errors path="admindata.userName"></form:errors></p>
  </div>
  <div class="form-group ">
    <label for="exampleInputPassword1">Password</label>
    <input  type="password" class="form-control" name="password" id="exampleInputPassword1"  placeholder="Password">
    <p style="color:red; font-size:15px"> <form:errors path="admindata.password"></form:errors></p>
  </div>
  
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Log In</button>
  </div>
  
</form>

</div>
</div>
</div>
</body>
</html>