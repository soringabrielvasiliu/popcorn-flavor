<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Popcorn Flavor | Login</title>
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
		<div class="container">
	    	<div class="row">
	        	<div class="col-sm-6 col-md-4 col-md-offset-4">
	        		<h1 class="text-center login-title">Sign in to continue to Homepage</h1>
	            	<div class="account-wall">
		            	<c:set var="var1" value="${message}"/>
		            	<c:if test="${message != null}">
		            		<div class="alert alert-danger col-md-10 col-md-offset-1">${message}</div>
		            	</c:if>
						<s:form method="post" commandName="u" class="form-signin">
							<s:input path="username" class="form-control" placeholder="Username" />
							<s:password path="password" class="form-control" placeholder="Password" />
							<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in" />
							<label class="checkbox pull-left">
			                    <input type="checkbox" value="remember-me">
			                    Remember me
			                </label>
			                <a href="javascript:;" class="pull-right need-help">Forgot your password?</a><span class="clearfix"></span>
	                        <div id="OR" class="hidden-xs">
	                            OR</div>
	                        <div class="row text-center sign-with">
                            <div class="col-md-12">
                                <h3 class="other-nw">
                                    Sign in with</h3>
                            </div>
                            <div class="col-md-12">
                                <div class="btn-group btn-group-justified">
                                    <a href="#" class="btn btn-primary">Facebook</a> <a href="#" class="btn btn-danger">
                                        Google +</a>
                                </div>
                            </div>
                        </div>
						</s:form>
		            </div>
		            <a href="#" class="text-center new-account">Create an account </a>
	    	    </div>
		    </div>
		</div>
	</body>
</html>