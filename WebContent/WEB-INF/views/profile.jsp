<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Josefin+Sans" />
<title>PopcornFlavor | Profile</title>
</head>
<body>
<span id='profile-container' modelAttribute="u">
	<div class="header-footer">
		<div class="logo-picture-and-info">
			<div class="logout-edit">
				<a href="${pageContext.request.contextPath}/homepage.html">HOME</a>
				<a href="${pageContext.request.contextPath}/account/logout.html">LOGOUT</a>
  				<a href="${pageContext.request.contextPath}/account/edit.html">EDIT PROFILE</a>
			</div>
			<a href="${pageContext.request.contextPath}/homepage.html">
				<img src="${pageContext.request.contextPath}/resources/images/pop3.png" alt="logo"/>
			</a>
			<h1>${u.username}</h1>
			<h2>Firstname: ${u.firstName}</h2>
			<h2>Lastname: ${u.lastName}</h2>
			<c:choose>
				<c:when test="${u.genre eq 'M'}">
					<h2>Gender: Male</h2>
				</c:when>
				<c:otherwise>
					<h2>Gender: Female</h2>
				</c:otherwise>
			</c:choose>
			<h2>Mail: ${u.mail}</h2>		
		</div>
		
		<form class="search-bar" action="${pageContext.request.contextPath}/find.html" method="post" commandName="search-form">
 			         <input class="search" type="text"  placeholder="Find Movies, TV Shows and Actors" name="searchName"/>
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
		<h1 class="title">${u.username}'s Activity</h1> 
		<h1>Your Ratings</h1>
		<h2>You haven't rated any movie</h2>
		<hr>
		<h1>Your Watchlist</h1>
		<h2>Your Watchlist is empty</h2>
		<hr>
		<h1>Your Latest Comments</h1>
		<h2>You haven't commented at any movie</h2>
		<hr>
		<h1>Recently Viewed</h1>
		<h2>There is no recent activity on the website</h2>
	</div>
</span>

</body>
</html>
