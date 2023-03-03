<%@page language="java" contentType="text/html" %>
<!Doctype html>
<html>
<head>
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<nav class="navbar  navbar-expand-lg fixed-top navbar-dark bg-dark">
   <div class="container-fluid">
    <a class="navbar-brand" href="#"><img class="logo" src="<%=request.getContextPath()%>/images/logo.png"/></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div style="margin-left:40%;" class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="#">Home</a>
         <a class="nav-link" href="#">Menu</a>
          <a class="nav-link" href="#">Reservation</a>
        <a class="nav-link" href="#">Gallery</a>
        <a class="nav-link" href="#">About</a>
      </div>
    </div>
  </div>
</nav>
<div>
  <h1 class="display-1">Welcome to The Yummy Bites</h1>
 </div>
 <div class="">
 
 </div>
</body>
</html>