<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>PopcornFlavor | Login</title>
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	<jsp:include page="header.jsp" />
	
	
<span class="connection_container">
<div class="main_login">
      <h1>Sign in to PopcornFlavor</h1>
      <div class="login_wrapper">     
        <s:form class="login_form" method="post" commandName="u">
          <s:input class="login_field" path="username" placeholder="Username" />
          <s:password class="login_field" path="password" placeholder="Password" />
          <input class="login_button" type="submit" value="Sign in" />
        </s:form>
        <div class="remember_forgot">
        	<c:set var="var1" value="${message}"/>
      			<c:if test="${message != null}">
        			<p class="alert">${message}</p>
      			</c:if>
          	<label class="remember_me_checkbox">
            	<input type="checkbox" value="remember-me">
              	Remember me
          	</label>
          	<a href="${pageContext.request.contextPath}/account/forgotPassword.html">Forgot your password?</a>
        </div>      
      </div>     
</div>
</span>
		
		
	<jsp:include page="footer.jsp" />	
	</body>
</html>