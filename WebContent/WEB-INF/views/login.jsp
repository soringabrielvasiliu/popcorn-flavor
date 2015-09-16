<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Josefin+Sans" />
	<title>Popcorn Flavor | Login</title>
</head>
	
<body>	
<span id="login-container">
	<div class="header-footer">
		<div class="logo-picture-and-info">
			<div class="home-register">
				<a href="${pageContext.request.contextPath}/homepage.html">HOME</a>
				<a href="${pageContext.request.contextPath}/account/register.html" class="register">REGISTER</a>
			</div>
			<a href="${pageContext.request.contextPath}/homepage.html">
				<img src="${pageContext.request.contextPath}/resources/images/pop3.png" alt="logo"/>
			</a>
		</div>
		<form class="search-bar" method="post" commandName="search-form">
			<input class="search" type="text"  placeholder="Find Movies, TV Shows and Actors"/>
			<input class="button" type="submit" value="Search">
  		</form>
  		<nav class="menu">
            <ul class="clearfix">     				
      				<li>
                <a href="#">MOVIES<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">TV Series</a></li>
                    <li><a href="#">Genres</a></li>
                    <li><a href="#">Video Games</a></li>
                    <li><a href="#">Coming Soon</a></li>
                </ul>
              </li>
              <li><a href="#">ACTORS</a></li>
      				<li>
                <a href="#">POPULAR<span class="arrow">&#9660;</span></a>
                <ul class="sub-menu">
                  <li><a href="#">Most Popular</a></li>
                  <li><a href="#">User Favorites</a></li>
                </ul>
              </li>     				
            </ul>
        </nav>
		<div class="footer-links">
	       <a href="#">About</a>
	       <a href="#">Help</a>
	       <a href="#">Facebook</a>
	       <a href="#">Twitter</a>
		</div>
	</div>
	<div class="content-container">
	<div class="login-wrapper">
		<c:set var="var1" value="${message}"/>
		<c:if test="${message != null}">
			<div class="alert">${message}</div>
		</c:if>      
			<h1>Login Form</h1>
			<s:form class="login-form" method="post" commandName="u">
				<s:input class="login-field" path="username" placeholder="Username" />
				<s:password class="login-field" path="password" placeholder="Password" />
				<input class="login-button" type="submit" value="Sign in" />
			</s:form>			
	        <div class="remember-forgot">
	          <label class="remember-me-checkbox">
	            <input type="checkbox" value="remember-me">
	              Remember me
	          </label>
	          <a href="${pageContext.request.contextPath}/account/forgotPassword.html">Forgot your password?</a>
	        </div> 
	</div>
	</div>
</span>
</body>
</html>