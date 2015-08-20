<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<section class='registration-pane'>
<spring:form method="post" commandName="register-form" >
 <form method="post"  commandName="u"  class="form-register">
	<label for='username'>Username<span class='required-element'></span><input type='text' id='username' name='username'/></label>
	<label for='password'>Password<span class='required-element'></span><input type='password' id='password' name='password'/></label>
	<label for='firstName'>First Name<input type='text' id='first-name' name='first_name' /></label>
	<label for='lastName'>Last Name<input type='text' id='last-name' name='last_name' /></label>
	<label for='mail'>Mail<span class='required-element'>*</span><input type='email' id='mail' name='mail'/></label>
	<label for='gender'>Gender
		<select id='gender' name='gender'>
			<option value='' hidden selected></option>
			<option value='male'>Male</option>
			<option value='female'>Female</option>
		</select>
	</label>
	<span class='registration-button submit-registration'>Register</span>
</section>
 </form>
 </spring:form>
</body>
</html>