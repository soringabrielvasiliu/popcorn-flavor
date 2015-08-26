<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Popcorn Flavor</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class='registration-pane'>
<spring:form method="post" commandName="register-form" >
	<form method="post" commandName="u"  class="form-register">
              <input type="text"  name="username"/>
              <input type="text"  name="firstName"/>
              <input type="text"  name="lastName"/>
              <input type="password"  name="password"/>
              <input type="text"  name="mail"/>
              <input type="text"  name="gender"/>
              <input type="submit" value="Go!" />
     </form>
 </spring:form>
 </div>
</body>
</html>