<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:include page="header.jsp" />
<section class='profile-main-wrapper'>

	<section class="profile-info">
		
		 <form   method="get" modelAttribute="u" >
			<h2>${u.username}</h2>
			<article>Firstname: ${u.firstName } </article>
			
			<article >Lastname: ${u.lastName} </article>
			<c:choose>
			<c:when test="${u.genre eq 'M'}">
			<article>Gender: Male </article>
			</c:when>
			<c:otherwise>
			<article>Gender: Female </article>
			</c:otherwise>
			</c:choose>
			
			<article>Mail: ${u.mail} </article>
		</form>
	</section>
			

	<section class="edit-profile">
		<h2>Edit user data </h2>
		<form class='edit-profile-info-form' method='post' commandName="u">
		
				<label for='first-name'>First Name: <input type='text' id='first-name' name='firstName' value= "${u.firstName } "  /></label>
				<label for='last-name'>Last Name: <input type='text' id='last-name' name='lastName' value=" ${u.lastName } " /></label>
				<label for='password'>New Password: <input type='password' id='password' name='password'   /></label>
				<label for='repeat-password'>Repeat new password: <input type='password' id='repeat-password' name='repeat_password'/></label>
				<span id="confirmMessage" class="confirmMessage"></span>
				
				<!-- HIDDEN VALUES -->
				<input type='text' name='hidden_first_name' value= "${u.firstName }" hidden/>
				<input type='text' name='hidden_last_name' value=" ${u.lastName } "hidden/>
				<!-- END HIDDEN VALUES -->
				<input type='submit'\>
		</form>
	</section>
	

</section>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/javaScript.js"></script>

</body>
</html>
