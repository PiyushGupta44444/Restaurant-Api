<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.yummyBites.services.AdminService"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="com.yummyBites.entities.AdminData"%>
<%@page language="java" contentType="text/html" %>
<!Doctype html>
<html>
<head>
<title>Welcome Page</title>
</head>
<body>
<h1>Success ....</h1>
<h1>${admindata.getUserName()}</h1>
</body>
</html>